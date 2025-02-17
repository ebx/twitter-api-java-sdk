package com.twitter.clientlib.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.twitter.clientlib.JSON;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;

public class MediaUploadResponseData {
  public static final String SERIALIZED_NAME_EXPIRES_AFTER_SECS = "expires_after_secs";
  @SerializedName(SERIALIZED_NAME_EXPIRES_AFTER_SECS)
  private Integer expiresAfterSecs;
  
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;
  
  public static final String SERIALIZED_NAME_MEDIA_KEY = "media_key";
  @SerializedName(SERIALIZED_NAME_MEDIA_KEY)
  private String mediaKey;
  
  public static final String SERIALIZED_NAME_PROCESSING_INFO = "processing_info";
  @SerializedName(SERIALIZED_NAME_PROCESSING_INFO)
  private ProcessingInfo processingInfo;
  
  public static final String SERIALIZED_NAME_SIZE = "size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private Integer size;
  
  public MediaUploadResponseData() {
  }
  
  public MediaUploadResponseData expiresAfterSecs(Integer expiresAfterSecs) {
    this.expiresAfterSecs = expiresAfterSecs;
    return this;
  }
  
  public MediaUploadResponseData id(String id) {
    this.id = id;
    return this;
  }
  
  public MediaUploadResponseData mediaKey(String mediaKey) {
    this.mediaKey = mediaKey;
    return this;
  }
  
  public MediaUploadResponseData processingInfo(ProcessingInfo processingInfo) {
    this.processingInfo = processingInfo;
    return this;
  }
  
  public MediaUploadResponseData size(Integer size) {
    this.size = size;
    return this;
  }
  
  public Integer getExpiresAfterSecs() {
    return expiresAfterSecs;
  }
  
  public void setExpiresAfterSecs(Integer expiresAfterSecs) {
    this.expiresAfterSecs = expiresAfterSecs;
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getMediaKey() {
    return mediaKey;
  }
  
  public void setMediaKey(String mediaKey) {
    this.mediaKey = mediaKey;
  }
  
  public ProcessingInfo getProcessingInfo() {
    return processingInfo;
  }
  
  public void setProcessingInfo(ProcessingInfo processingInfo) {
    this.processingInfo = processingInfo;
  }
  
  public Integer getSize() {
    return size;
  }
  
  public void setSize(Integer size) {
    this.size = size;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaUploadResponseData that = (MediaUploadResponseData) o;
    return Objects.equals(expiresAfterSecs, that.expiresAfterSecs) && Objects.equals(id, that.id)
        && Objects.equals(mediaKey, that.mediaKey) && Objects.equals(processingInfo,
        that.processingInfo) && Objects.equals(size, that.size);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(expiresAfterSecs, id, mediaKey, processingInfo, size);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadMediaResponseData {\n");
    sb.append("    expiresAfterSecs: ").append(toIndentedString(expiresAfterSecs)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    mediaKey: ").append(toIndentedString(mediaKey)).append("\n");
    sb.append("    processingInfo: ").append(toIndentedString(processingInfo)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("}");
    return sb.toString();
  }
  
  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;
  
  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("expires_after_secs");
    openapiFields.add("id");
    openapiFields.add("media_key");
    openapiFields.add("processing_info");
    openapiFields.add("size");
    
    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("expires_after_secs");
    openapiRequiredFields.add("id");
    openapiRequiredFields.add("media_key");
    openapiRequiredFields.add("processing_info");
    openapiRequiredFields.add("size");
  }
  
  /**
   * Validates the JSON Object and throws an exception if issues found
   *
   * @param jsonObj JSON Object
   * @throws IOException if the JSON Object is invalid with respect to UploadMediaResponseData
   */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
    // if (jsonObj == null) {
    //   if (UploadMediaResponseData.openapiRequiredFields.isEmpty()) {
    //     return;
    //   } else { // has required fields
    //     throw new IllegalArgumentException(String.format("The required field(s) %s in UploadMediaResponseData is not found in the empty JSON string", UploadMediaResponseData.openapiRequiredFields.toString()));
    //   }
    // }
    
    
    // check to make sure all required properties/fields are present in the JSON string
    for (String requiredField : MediaUploadResponseData.openapiRequiredFields) {
      if (jsonObj.get(requiredField) == null) {
        throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
      }
    }
    if (jsonObj.get("expires_after_secs") != null && !jsonObj.get("expires_after_secs").isJsonPrimitive()) {
      throw new IllegalArgumentException(String.format("Expected the field `expires_after_secs` to be a primitive type in the JSON string but got `%s`", jsonObj.get("expires_after_secs").toString()));
    }
    if (jsonObj.get("id") != null && !jsonObj.get("id").isJsonPrimitive()) {
      throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
    }
    if (jsonObj.get("media_key") != null && !jsonObj.get("media_key").isJsonPrimitive()) {
      throw new IllegalArgumentException(String.format("Expected the field `media_key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("media_key").toString()));
    }
    if (jsonObj.get("processing_info") != null && !jsonObj.get("processing_info").isJsonObject()) {
      throw new IllegalArgumentException(String.format("Expected the field `processing_info` to be a primitive type in the JSON string but got `%s`", jsonObj.get("processing_info").toString()));
    }
    if (jsonObj.get("size") != null && !jsonObj.get("size").isJsonPrimitive()) {
      throw new IllegalArgumentException(String.format("Expected the field `size` to be a primitive type in the JSON string but got `%s`", jsonObj.get("size").toString()));
    }
  }
  
  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
      if (!MediaUploadResponseData.class.isAssignableFrom(type.getRawType())) {
        return null; // this class only serializes 'UploadMediaResponseData' and its subtypes
      }
      final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
      final TypeAdapter<MediaUploadResponseData> thisAdapter
          = gson.getDelegateAdapter(this, TypeToken.get(MediaUploadResponseData.class));
      
      return (TypeAdapter<T>) new TypeAdapter<MediaUploadResponseData>() {
        @Override
        public void write(JsonWriter out, MediaUploadResponseData value) throws IOException {
          JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
          elementAdapter.write(out, obj);
        }
        
        @Override
        public MediaUploadResponseData read(JsonReader in) throws IOException {
          JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
          validateJsonObject(jsonObj);
          return thisAdapter.fromJsonTree(jsonObj);
        }
        
      }.nullSafe();
    }
  }
  
  /**
   * Create an instance of UploadMediaResponseData given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of UploadMediaResponseData
   * @throws IOException if the JSON string is invalid with respect to UploadMediaResponseData
   */
  public static MediaUploadResponseData fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, MediaUploadResponseData.class);
  }
  
  /**
   * Convert an instance of UploadMediaResponseData to an JSON string
   *
   * @return JSON string
   */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
  
  public static class ProcessingInfo {
    public static final String SERIALIZED_NAME_CHECK_AFTER_SECS = "check_after_secs";
    @SerializedName(SERIALIZED_NAME_CHECK_AFTER_SECS)
    private Integer checkAfterSecs;
    
    public static final String SERIALIZED_NAME_PROCESS_PERCENT = "process_percent";
    @SerializedName(SERIALIZED_NAME_PROCESS_PERCENT)
    private Integer processPercent;
    
    public static final String SERIALIZED_NAME_STATE = "state";
    @SerializedName(SERIALIZED_NAME_STATE)
    private State state;
    
    public ProcessingInfo() {
    }
    
    public ProcessingInfo checkAfterSecs(Integer checkAfterSecs) {
      this.checkAfterSecs = checkAfterSecs;
      return this;
    }
    
    public ProcessingInfo processPercent(Integer processPercent) {
      this.processPercent = processPercent;
      return this;
    }
    
    public ProcessingInfo state(State state) {
      this.state = state;
      return this;
    }
    
    public Integer getCheckAfterSecs() {
      return checkAfterSecs;
    }
    
    public void setCheckAfterSecs(Integer checkAfterSecs) {
      this.checkAfterSecs = checkAfterSecs;
    }
    
    public Integer getProcessPercent() {
      return processPercent;
    }
    
    public void setProcessPercent(Integer processPercent) {
      this.processPercent = processPercent;
    }
    
    public State getState() {
      return state;
    }
    
    public void setState(State state) {
      this.state = state;
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      ProcessingInfo that = (ProcessingInfo) o;
      return Objects.equals(checkAfterSecs, that.checkAfterSecs) && Objects.equals(processPercent,
          that.processPercent) && state == that.state;
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(checkAfterSecs, processPercent, state);
    }
    
    @Override
    public String toString() {
      return "class ProcessingInfo {\n" +
          "    checkAfterSecs: " + toIndentedString(checkAfterSecs) + "\n" +
          "    processPercent: " + toIndentedString(processPercent) + "\n" +
          "    state: " + toIndentedString(state) + "\n" +
          "}";
    }
    
    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
      if (o == null) {
        return "null";
      }
      return o.toString().replace("\n", "\n    ");
    }
    
    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;
    
    static {
      // a set of all properties/fields (JSON key names)
      openapiFields = new HashSet<String>();
      openapiFields.add("check_after_secs");
      openapiFields.add("process_percent");
      openapiFields.add("state");
      
      // a set of required properties/fields (JSON key names)
      openapiRequiredFields = new HashSet<String>();
      openapiRequiredFields.add("check_after_secs");
      openapiRequiredFields.add("process_percent");
      openapiRequiredFields.add("state");
    }
    
    /**
     * Validates the JSON Object and throws an exception if issues found
     *
     * @param jsonObj JSON Object
     * @throws IOException if the JSON Object is invalid with respect to ProcessingInfo
     */
    public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      // if (jsonObj == null) {
      //   if (ProcessingInfo.openapiRequiredFields.isEmpty()) {
      //     return;
      //   } else { // has required fields
      //     throw new IllegalArgumentException(String.format("The required field(s) %s in ProcessingInfo is not found in the empty JSON string", UploadMediaResponseData.openapiRequiredFields.toString()));
      //   }
      // }
      
      
      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : ProcessingInfo.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("check_after_secs") != null && !jsonObj.get("check_after_secs").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `check_after_secs` to be a primitive type in the JSON string but got `%s`", jsonObj.get("check_after_secs").toString()));
      }
      if (jsonObj.get("process_percent") != null && !jsonObj.get("process_percent").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `process_percent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("process_percent").toString()));
      }
      if (jsonObj.get("state") != null && !jsonObj.get("state").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `state` to be a primitive type in the JSON string but got `%s`", jsonObj.get("state").toString()));
      }
    }
    
    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
      @SuppressWarnings("unchecked")
      @Override
      public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (!ProcessingInfo.class.isAssignableFrom(type.getRawType())) {
          return null; // this class only serializes 'ProcessingInfo' and its subtypes
        }
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
        final TypeAdapter<ProcessingInfo> thisAdapter
            = gson.getDelegateAdapter(this, TypeToken.get(ProcessingInfo.class));
        
        return (TypeAdapter<T>) new TypeAdapter<ProcessingInfo>() {
          @Override
          public void write(JsonWriter out, ProcessingInfo value) throws IOException {
            JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
            elementAdapter.write(out, obj);
          }
          
          @Override
          public ProcessingInfo read(JsonReader in) throws IOException {
            JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
            validateJsonObject(jsonObj);
            return thisAdapter.fromJsonTree(jsonObj);
          }
          
        }.nullSafe();
      }
    }
  }
  
  @JsonAdapter(State.class)
  public enum State {
    SUCCEEDED("succeeded"),
    
    IN_PROGRESS("in_progress"),
    
    PENDING("pending"),
    
    FAILED("failed");
    
    private String value;
    
    State(String value) {
      this.value = value;
    }
    
    public String getValue() {
      return value;
    }
    
    @Override
    public String toString() {
      return String.valueOf(value);
    }
    
    public static State fromValue(String value) {
      for (State state : State.values()) {
        if (state.value.equals(value)) {
          return state;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
    
    public static class Adapter extends TypeAdapter<State> {
      @Override
      public void write(final JsonWriter jsonWriter, final State enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }
      
      @Override
      public State read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return State.fromValue(value);
      }
    }
  }
  
}
