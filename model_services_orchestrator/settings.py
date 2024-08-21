import typing
from typing import Optional

from pydantic import SecretStr
from pydantic_settings import BaseSettings


class Settings(BaseSettings):
    google_application_credentials_k8s_secret: Optional[str] = None
    aws_k8s_secret: Optional[str] = None

    kubernetes_host: str = 'localhost'
    kubernetes_port: int = 6443
    kubernetes_api_token: typing.Optional[SecretStr] = None
    kubernetes_pull_image_secret_name: Optional[str] = None
    mqtt_host: str = 'localhost'
    mqtt_port: int = 1883
    mqtt_username: str = ''
    mqtt_password: SecretStr = SecretStr('')
    simulator_name: str = ''
