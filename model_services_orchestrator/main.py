#  This work is based on original code developed and copyrighted by TNO 2023.
#  Subsequent contributions are licensed to you by the developers of such code and are
#  made available to the Project under one or several contributor license agreements.
#
#  This work is licensed to you under the Apache License, Version 2.0.
#  You may obtain a copy of the license at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Contributors:
#      TNO         - Initial implementation
#  Manager:
#      TNO

import signal
import typing

import kubernetes  # type:ignore[import-untyped]
from model_services_orchestrator.async_application import AsyncApplications
from model_services_orchestrator.k8s_api import K8sApi
from model_services_orchestrator.log import LOGGER
from model_services_orchestrator.model_inventory import ModelInventory
from model_services_orchestrator.model_state_observer import ModelStateObserver
from model_services_orchestrator.mqtt_application import MQTTApplication
from model_services_orchestrator.poll_pod_health_application import \
    PollPodHealthApplication
from model_services_orchestrator.settings import Settings

TO_STOP_ON_SIGNAL: typing.List[typing.Callable[[], None]] = []

def all_stop_on_signal(_signal_num, _stack_frame):
    for handler in TO_STOP_ON_SIGNAL:
        handler()


signal.signal(signal.SIGINT, all_stop_on_signal)

# Turn off 'InsecureRequestWarning: Unverified HTTPS request' of urllib3 if available
try:
    import urllib3  # type:ignore[import-untyped]
except ImportError:
    pass
else:
    urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)


class AdditionalConfig(typing.TypedDict):
    secret_env: typing.Optional[dict[str, tuple[str,str]]]
    secret_mounts: typing.Optional[dict[str,str]]
    additional_env: typing.Optional[dict[str,str]]

def get_gcp_config(k8s_secret: str, additional_config: AdditionalConfig) -> AdditionalConfig:
    """
    Requires a kubernetes secret with the content of the ADC file in a key application_default_credentials.json
    See https://cloud.google.com/docs/authentication/application-default-credentials
    """

    additional_env = {}
    secret_mounts = {}
    if additional_config["additional_env"] is not None:
        additional_env = additional_config["additional_env"]
    if additional_config["secret_mounts"] is not None:
        additional_env = additional_config["secret_mounts"]

    mount_point="/run/secrets/gcp/"
    additional_env["GOOGLE_APPLICATION_CREDENTIALS"]=f"{mount_point}/application_default_credentials.json"
    secret_mounts[k8s_secret]=mount_point
    additional_config["additional_env"] = additional_env
    additional_config["secret_mounts"] = secret_mounts
    return additional_config

def get_aws_config(k8s_secret: str, additional_config: AdditionalConfig) -> AdditionalConfig:
    """
    Requires a kubernetes secret to exist with the following fields:
        aws_access_key_id
        aws_secret_access_key
        aws_default_region
    See: https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-envvars.html
    """
    secret_env={}
    if additional_config["secret_env"] is not None:
        secret_env=additional_config["secret_env"]
    secret_env["AWS_ACCESS_KEY_ID"]=(k8s_secret, "aws_access_key_id")
    secret_env["AWS_SECRET_ACCESS_KEY"]=(k8s_secret, "aws_secret_access_key")
    secret_env["AWS_DEFAULT_REGION"]=(k8s_secret, "aws_default_region")
    additional_config["secret_env"] = secret_env
    return additional_config

def main():
    async_applications = AsyncApplications()
    TO_STOP_ON_SIGNAL.append(async_applications.stop)

    config = Settings()
    LOGGER.info("Config: %s", config)

    configuration = kubernetes.client.Configuration()
    configuration.api_key_prefix['authorization'] = 'Bearer'
    configuration.api_key['authorization'] = config.kubernetes_api_token.get_secret_value()
    configuration.host = f"https://{config.kubernetes_host}:{config.kubernetes_port}"
    configuration.verify_ssl = False
    configuration.retries = 3

    additional_config: AdditionalConfig = { # type:ignore[annotation-unchecked]
            "secret_env": None,
            "secret_mounts": None,
            "additional_env": None,
    }
    if config.google_application_credentials_k8s_secret is not None:
        additional_config=get_gcp_config(config.google_application_credentials_k8s_secret, additional_config)

    if config.aws_k8s_secret is not None:
        additional_config=get_aws_config(config.aws_k8s_secret, additional_config)

    # Enter a context with an instance of the API kubernetes.client
    with kubernetes.client.ApiClient(configuration) as api_client:
        k8s_api = K8sApi(api_client,
                         async_applications.loop,
                         config.kubernetes_pull_image_secret_name.strip(), **additional_config)
        model_inventory = ModelInventory()
        mqtt_application = MQTTApplication(
            simulation_topic_name=config.simulator_name.lower(),
            mqtt_host=config.mqtt_host,
            mqtt_port=config.mqtt_port,
            mqtt_username=config.mqtt_username,
            mqtt_password=config.mqtt_password.get_secret_value(),
            model_inventory=model_inventory,
            k8s_api=k8s_api)
        poll_pod_health_application = PollPodHealthApplication(model_inventory=model_inventory,
                                                               k8s_api=k8s_api)
        ModelStateObserver(model_inventory, mqtt_application)
        async_applications.add_application(mqtt_application)
        async_applications.add_application(poll_pod_health_application)
        LOGGER.info('Ready for processing...')
        async_applications.run_all()


if __name__ == "__main__":
    main()
