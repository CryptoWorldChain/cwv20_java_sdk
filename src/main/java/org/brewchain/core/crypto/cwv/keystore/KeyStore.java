// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: keyStore.proto

package org.brewchain.core.crypto.cwv.keystore;

public final class KeyStore {
  private KeyStore() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface KeyStoreValueOrBuilder extends
      // @@protoc_insertion_point(interface_extends:org.brewchain.core.crypto.cwv.keystore.KeyStoreValue)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string address = 1;</code>
     */
    java.lang.String getAddress();
    /**
     * <code>string address = 1;</code>
     */
    com.google.protobuf.ByteString
        getAddressBytes();

    /**
     * <code>string bcuid = 2;</code>
     */
    java.lang.String getBcuid();
    /**
     * <code>string bcuid = 2;</code>
     */
    com.google.protobuf.ByteString
        getBcuidBytes();

    /**
     * <code>string prikey = 3;</code>
     */
    java.lang.String getPrikey();
    /**
     * <code>string prikey = 3;</code>
     */
    com.google.protobuf.ByteString
        getPrikeyBytes();

    /**
     * <code>string pubkey = 4;</code>
     */
    java.lang.String getPubkey();
    /**
     * <code>string pubkey = 4;</code>
     */
    com.google.protobuf.ByteString
        getPubkeyBytes();
  }
  /**
   * Protobuf type {@code org.brewchain.core.crypto.cwv.keystore.KeyStoreValue}
   */
  public  static final class KeyStoreValue extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:org.brewchain.core.crypto.cwv.keystore.KeyStoreValue)
      KeyStoreValueOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use KeyStoreValue.newBuilder() to construct.
    private KeyStoreValue(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private KeyStoreValue() {
      address_ = "";
      bcuid_ = "";
      prikey_ = "";
      pubkey_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private KeyStoreValue(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
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
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              address_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              bcuid_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              prikey_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              pubkey_ = s;
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
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
      return org.brewchain.core.crypto.cwv.keystore.KeyStore.internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.brewchain.core.crypto.cwv.keystore.KeyStore.internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue.class, org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue.Builder.class);
    }

    public static final int ADDRESS_FIELD_NUMBER = 1;
    private volatile java.lang.Object address_;
    /**
     * <code>string address = 1;</code>
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        address_ = s;
        return s;
      }
    }
    /**
     * <code>string address = 1;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int BCUID_FIELD_NUMBER = 2;
    private volatile java.lang.Object bcuid_;
    /**
     * <code>string bcuid = 2;</code>
     */
    public java.lang.String getBcuid() {
      java.lang.Object ref = bcuid_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        bcuid_ = s;
        return s;
      }
    }
    /**
     * <code>string bcuid = 2;</code>
     */
    public com.google.protobuf.ByteString
        getBcuidBytes() {
      java.lang.Object ref = bcuid_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        bcuid_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PRIKEY_FIELD_NUMBER = 3;
    private volatile java.lang.Object prikey_;
    /**
     * <code>string prikey = 3;</code>
     */
    public java.lang.String getPrikey() {
      java.lang.Object ref = prikey_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        prikey_ = s;
        return s;
      }
    }
    /**
     * <code>string prikey = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPrikeyBytes() {
      java.lang.Object ref = prikey_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        prikey_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PUBKEY_FIELD_NUMBER = 4;
    private volatile java.lang.Object pubkey_;
    /**
     * <code>string pubkey = 4;</code>
     */
    public java.lang.String getPubkey() {
      java.lang.Object ref = pubkey_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        pubkey_ = s;
        return s;
      }
    }
    /**
     * <code>string pubkey = 4;</code>
     */
    public com.google.protobuf.ByteString
        getPubkeyBytes() {
      java.lang.Object ref = pubkey_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pubkey_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getAddressBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, address_);
      }
      if (!getBcuidBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, bcuid_);
      }
      if (!getPrikeyBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, prikey_);
      }
      if (!getPubkeyBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, pubkey_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getAddressBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, address_);
      }
      if (!getBcuidBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, bcuid_);
      }
      if (!getPrikeyBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, prikey_);
      }
      if (!getPubkeyBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, pubkey_);
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
      if (!(obj instanceof org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue)) {
        return super.equals(obj);
      }
      org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue other = (org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue) obj;

      boolean result = true;
      result = result && getAddress()
          .equals(other.getAddress());
      result = result && getBcuid()
          .equals(other.getBcuid());
      result = result && getPrikey()
          .equals(other.getPrikey());
      result = result && getPubkey()
          .equals(other.getPubkey());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
      hash = (53 * hash) + getAddress().hashCode();
      hash = (37 * hash) + BCUID_FIELD_NUMBER;
      hash = (53 * hash) + getBcuid().hashCode();
      hash = (37 * hash) + PRIKEY_FIELD_NUMBER;
      hash = (53 * hash) + getPrikey().hashCode();
      hash = (37 * hash) + PUBKEY_FIELD_NUMBER;
      hash = (53 * hash) + getPubkey().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parseFrom(
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
    public static Builder newBuilder(org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue prototype) {
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
     * Protobuf type {@code org.brewchain.core.crypto.cwv.keystore.KeyStoreValue}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:org.brewchain.core.crypto.cwv.keystore.KeyStoreValue)
        org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValueOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return org.brewchain.core.crypto.cwv.keystore.KeyStore.internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return org.brewchain.core.crypto.cwv.keystore.KeyStore.internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue.class, org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue.Builder.class);
      }

      // Construct using org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue.newBuilder()
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
        address_ = "";

        bcuid_ = "";

        prikey_ = "";

        pubkey_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.brewchain.core.crypto.cwv.keystore.KeyStore.internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_descriptor;
      }

      @java.lang.Override
      public org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue getDefaultInstanceForType() {
        return org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue.getDefaultInstance();
      }

      @java.lang.Override
      public org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue build() {
        org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue buildPartial() {
        org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue result = new org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue(this);
        result.address_ = address_;
        result.bcuid_ = bcuid_;
        result.prikey_ = prikey_;
        result.pubkey_ = pubkey_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue) {
          return mergeFrom((org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue other) {
        if (other == org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue.getDefaultInstance()) return this;
        if (!other.getAddress().isEmpty()) {
          address_ = other.address_;
          onChanged();
        }
        if (!other.getBcuid().isEmpty()) {
          bcuid_ = other.bcuid_;
          onChanged();
        }
        if (!other.getPrikey().isEmpty()) {
          prikey_ = other.prikey_;
          onChanged();
        }
        if (!other.getPubkey().isEmpty()) {
          pubkey_ = other.pubkey_;
          onChanged();
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
        org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object address_ = "";
      /**
       * <code>string address = 1;</code>
       */
      public java.lang.String getAddress() {
        java.lang.Object ref = address_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          address_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string address = 1;</code>
       */
      public com.google.protobuf.ByteString
          getAddressBytes() {
        java.lang.Object ref = address_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          address_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string address = 1;</code>
       */
      public Builder setAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        address_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string address = 1;</code>
       */
      public Builder clearAddress() {

        address_ = getDefaultInstance().getAddress();
        onChanged();
        return this;
      }
      /**
       * <code>string address = 1;</code>
       */
      public Builder setAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        address_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object bcuid_ = "";
      /**
       * <code>string bcuid = 2;</code>
       */
      public java.lang.String getBcuid() {
        java.lang.Object ref = bcuid_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          bcuid_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string bcuid = 2;</code>
       */
      public com.google.protobuf.ByteString
          getBcuidBytes() {
        java.lang.Object ref = bcuid_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          bcuid_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string bcuid = 2;</code>
       */
      public Builder setBcuid(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        bcuid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string bcuid = 2;</code>
       */
      public Builder clearBcuid() {

        bcuid_ = getDefaultInstance().getBcuid();
        onChanged();
        return this;
      }
      /**
       * <code>string bcuid = 2;</code>
       */
      public Builder setBcuidBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        bcuid_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object prikey_ = "";
      /**
       * <code>string prikey = 3;</code>
       */
      public java.lang.String getPrikey() {
        java.lang.Object ref = prikey_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          prikey_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string prikey = 3;</code>
       */
      public com.google.protobuf.ByteString
          getPrikeyBytes() {
        java.lang.Object ref = prikey_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          prikey_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string prikey = 3;</code>
       */
      public Builder setPrikey(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        prikey_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string prikey = 3;</code>
       */
      public Builder clearPrikey() {

        prikey_ = getDefaultInstance().getPrikey();
        onChanged();
        return this;
      }
      /**
       * <code>string prikey = 3;</code>
       */
      public Builder setPrikeyBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        prikey_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object pubkey_ = "";
      /**
       * <code>string pubkey = 4;</code>
       */
      public java.lang.String getPubkey() {
        java.lang.Object ref = pubkey_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          pubkey_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string pubkey = 4;</code>
       */
      public com.google.protobuf.ByteString
          getPubkeyBytes() {
        java.lang.Object ref = pubkey_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pubkey_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string pubkey = 4;</code>
       */
      public Builder setPubkey(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        pubkey_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string pubkey = 4;</code>
       */
      public Builder clearPubkey() {

        pubkey_ = getDefaultInstance().getPubkey();
        onChanged();
        return this;
      }
      /**
       * <code>string pubkey = 4;</code>
       */
      public Builder setPubkeyBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        pubkey_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:org.brewchain.core.crypto.cwv.keystore.KeyStoreValue)
    }

    // @@protoc_insertion_point(class_scope:org.brewchain.core.crypto.cwv.keystore.KeyStoreValue)
    private static final org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue();
    }

    public static org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<KeyStoreValue>
        PARSER = new com.google.protobuf.AbstractParser<KeyStoreValue>() {
      @java.lang.Override
      public KeyStoreValue parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new KeyStoreValue(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<KeyStoreValue> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<KeyStoreValue> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public org.brewchain.core.crypto.cwv.keystore.KeyStore.KeyStoreValue getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016keyStore.proto\022&org.brewchain.core.cry" +
      "pto.cwv.keystore\"O\n\rKeyStoreValue\022\017\n\007add" +
      "ress\030\001 \001(\t\022\r\n\005bcuid\030\002 \001(\t\022\016\n\006prikey\030\003 \001(" +
      "\t\022\016\n\006pubkey\030\004 \001(\tb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_org_brewchain_core_crypto_cwv_keystore_KeyStoreValue_descriptor,
        new java.lang.String[] { "Address", "Bcuid", "Prikey", "Pubkey", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
