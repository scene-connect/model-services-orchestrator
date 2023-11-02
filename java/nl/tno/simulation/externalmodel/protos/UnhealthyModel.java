// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: lifecycle.proto

package nl.tno.simulation.externalmodel.protos;

/**
 * Protobuf type {@code UnhealthyModel}
 */
public final class UnhealthyModel extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:UnhealthyModel)
    UnhealthyModelOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UnhealthyModel.newBuilder() to construct.
  private UnhealthyModel(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UnhealthyModel() {
    status_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UnhealthyModel();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UnhealthyModel(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {
            int rawValue = input.readEnum();

            status_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return nl.tno.simulation.externalmodel.protos.Lifecycle.internal_static_UnhealthyModel_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return nl.tno.simulation.externalmodel.protos.Lifecycle.internal_static_UnhealthyModel_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            nl.tno.simulation.externalmodel.protos.UnhealthyModel.class, nl.tno.simulation.externalmodel.protos.UnhealthyModel.Builder.class);
  }

  public static final int STATUS_FIELD_NUMBER = 1;
  private int status_;
  /**
   * <code>.UnhealthyModelStatus status = 1;</code>
   * @return The enum numeric value on the wire for status.
   */
  @java.lang.Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.UnhealthyModelStatus status = 1;</code>
   * @return The status.
   */
  @java.lang.Override public nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus getStatus() {
    @SuppressWarnings("deprecation")
    nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus result = nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus.valueOf(status_);
    return result == null ? nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus.UNRECOGNIZED : result;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (status_ != nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus.NOPROGRESS.getNumber()) {
      output.writeEnum(1, status_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus.NOPROGRESS.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, status_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof nl.tno.simulation.externalmodel.protos.UnhealthyModel)) {
      return super.equals(obj);
    }
    nl.tno.simulation.externalmodel.protos.UnhealthyModel other = (nl.tno.simulation.externalmodel.protos.UnhealthyModel) obj;

    if (status_ != other.status_) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(nl.tno.simulation.externalmodel.protos.UnhealthyModel prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code UnhealthyModel}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:UnhealthyModel)
      nl.tno.simulation.externalmodel.protos.UnhealthyModelOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return nl.tno.simulation.externalmodel.protos.Lifecycle.internal_static_UnhealthyModel_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return nl.tno.simulation.externalmodel.protos.Lifecycle.internal_static_UnhealthyModel_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              nl.tno.simulation.externalmodel.protos.UnhealthyModel.class, nl.tno.simulation.externalmodel.protos.UnhealthyModel.Builder.class);
    }

    // Construct using nl.tno.simulation.externalmodel.protos.UnhealthyModel.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      status_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return nl.tno.simulation.externalmodel.protos.Lifecycle.internal_static_UnhealthyModel_descriptor;
    }

    @java.lang.Override
    public nl.tno.simulation.externalmodel.protos.UnhealthyModel getDefaultInstanceForType() {
      return nl.tno.simulation.externalmodel.protos.UnhealthyModel.getDefaultInstance();
    }

    @java.lang.Override
    public nl.tno.simulation.externalmodel.protos.UnhealthyModel build() {
      nl.tno.simulation.externalmodel.protos.UnhealthyModel result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public nl.tno.simulation.externalmodel.protos.UnhealthyModel buildPartial() {
      nl.tno.simulation.externalmodel.protos.UnhealthyModel result = new nl.tno.simulation.externalmodel.protos.UnhealthyModel(this);
      result.status_ = status_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof nl.tno.simulation.externalmodel.protos.UnhealthyModel) {
        return mergeFrom((nl.tno.simulation.externalmodel.protos.UnhealthyModel)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(nl.tno.simulation.externalmodel.protos.UnhealthyModel other) {
      if (other == nl.tno.simulation.externalmodel.protos.UnhealthyModel.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      nl.tno.simulation.externalmodel.protos.UnhealthyModel parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (nl.tno.simulation.externalmodel.protos.UnhealthyModel) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int status_ = 0;
    /**
     * <code>.UnhealthyModelStatus status = 1;</code>
     * @return The enum numeric value on the wire for status.
     */
    @java.lang.Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.UnhealthyModelStatus status = 1;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.UnhealthyModelStatus status = 1;</code>
     * @return The status.
     */
    @java.lang.Override
    public nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus getStatus() {
      @SuppressWarnings("deprecation")
      nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus result = nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus.valueOf(status_);
      return result == null ? nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus.UNRECOGNIZED : result;
    }
    /**
     * <code>.UnhealthyModelStatus status = 1;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(nl.tno.simulation.externalmodel.protos.UnhealthyModelStatus value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.UnhealthyModelStatus status = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:UnhealthyModel)
  }

  // @@protoc_insertion_point(class_scope:UnhealthyModel)
  private static final nl.tno.simulation.externalmodel.protos.UnhealthyModel DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new nl.tno.simulation.externalmodel.protos.UnhealthyModel();
  }

  public static nl.tno.simulation.externalmodel.protos.UnhealthyModel getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UnhealthyModel>
      PARSER = new com.google.protobuf.AbstractParser<UnhealthyModel>() {
    @java.lang.Override
    public UnhealthyModel parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UnhealthyModel(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UnhealthyModel> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UnhealthyModel> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public nl.tno.simulation.externalmodel.protos.UnhealthyModel getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
