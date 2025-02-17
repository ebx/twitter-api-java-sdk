package com.twitter.clientlib.api;

import com.google.gson.reflect.TypeToken;
import com.twitter.clientlib.ApiCallback;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.ApiResponse;
import com.twitter.clientlib.Pair;
import com.twitter.clientlib.model.MediaUploadRequest;
import com.twitter.clientlib.model.MediaUploadResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MediaApi extends ApiCommon{
  
  private okhttp3.Call createMediaUploadCall(
      MediaUploadRequest mediaUploadRequest, final ApiCallback _callback) throws ApiException {
    Object localVarPostBody = mediaUploadRequest;
    
    // create path and map variables
    String localVarPath = "/2/media/upload";
    
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();
    
    final String[] localVarAccepts = {
        "application/json", "application/problem+json"
    };
    final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
    if (localVarAccept != null) {
      localVarHeaderParams.put("Accept", localVarAccept);
    }
    
    final String[] localVarContentTypes = {
        "application/json"
    };
    final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
    if (localVarContentType != null) {
      localVarHeaderParams.put("Content-Type", localVarContentType);
    }
    
    String[] localVarAuthNames = new String[] { "OAuth2UserToken", "UserToken" };
    return localVarApiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, reduceAuthNames(localVarAuthNames), _callback);
  }
  
  private okhttp3.Call mediaUploadValidateBeforeCall(MediaUploadRequest mediaUploadRequest,
      final ApiCallback _callback) throws ApiException {
    
    // verify the required parameter 'mediaUploadRequest' is set
    if (mediaUploadRequest == null) {
      throw new ApiException("Missing the required parameter 'mediaUploadRequest' when calling "
          + "mediaUpload(Async)");
    }
    
    
    okhttp3.Call localVarCall = createMediaUploadCall(mediaUploadRequest, _callback);
    return localVarCall;
    
  }
  
  private ApiResponse<MediaUploadResponse> mediaUploadWithHttpInfo(
      MediaUploadRequest mediaUploadRequest) throws ApiException {
    okhttp3.Call localVarCall = mediaUploadValidateBeforeCall(mediaUploadRequest, null);
    try {
      Type localVarReturnType = new TypeToken<MediaUploadResponse>(){}.getType();
      return localVarApiClient.execute(localVarCall, localVarReturnType);
    } catch (ApiException e) {
      e.setErrorObject(localVarApiClient.getJSON().getGson().fromJson(e.getResponseBody(), new TypeToken<com.twitter.clientlib.model.ProblemOrError>(){}.getType()));
      throw e;
    }
  }
  
  private okhttp3.Call mediaUploadAsync(MediaUploadRequest mediaUploadRequest,
      final ApiCallback<MediaUploadResponse> _callback) throws ApiException {
    
    okhttp3.Call localVarCall = mediaUploadValidateBeforeCall(mediaUploadRequest, _callback);
    Type localVarReturnType = new TypeToken<MediaUploadResponse>(){}.getType();
    localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
    return localVarCall;
  }
  
  public APIMediaUploadRequest mediaUpload(MediaUploadRequest mediaUploadRequest) {
    return new APIMediaUploadRequest(mediaUploadRequest);
  }
  
  public class APIMediaUploadRequest {
    private final MediaUploadRequest mediaUploadRequest;
    
    private APIMediaUploadRequest(MediaUploadRequest mediaUploadRequest) {
      this.mediaUploadRequest = mediaUploadRequest;
    }
    
    /**
     * Build call for media upload
     * @param _callback ApiCallback API callback
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
    <table summary="Response Details" border="1">
    <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
    <tr><td> 201 </td><td> The request has succeeded. </td><td>  -  </td></tr>
    <tr><td> 0 </td><td> The request has failed. </td><td>  -  </td></tr>
    </table>
     */
    public okhttp3.Call buildCall(final ApiCallback _callback) throws ApiException {
      return createMediaUploadCall(mediaUploadRequest, _callback);
    }
    
    /**
     * Execute mediaUpload request
     * @return MediaUploadResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
    <table summary="Response Details" border="1">
    <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
    <tr><td> 201 </td><td> The request has succeeded. </td><td>  -  </td></tr>
    <tr><td> 0 </td><td> The request has failed. </td><td>  -  </td></tr>
    </table>
     */
    public MediaUploadResponse execute() throws ApiException {
      
      ApiResponse<MediaUploadResponse>
          localVarResp = mediaUploadWithHttpInfo(mediaUploadRequest);
      return localVarResp.getData();
    }
    /**
     * Calls the API using a retry mechanism to handle rate limits errors.
     *
     */
    public MediaUploadResponse execute(Integer retries) throws ApiException {
      MediaUploadResponse localVarResp;
      try{
        localVarResp = execute();
      } catch (ApiException e) {
        if(handleRateLimit(e, retries)) {
          return execute(retries - 1);
        } else {
          throw e;
        }
      }
      return localVarResp;
    }
    /**
     * Execute mediaUpload request with HTTP info returned
     * @return ApiResponse&lt;MediaUploadResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
    <table summary="Response Details" border="1">
    <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
    <tr><td> 201 </td><td> The request has succeeded. </td><td>  -  </td></tr>
    <tr><td> 0 </td><td> The request has failed. </td><td>  -  </td></tr>
    </table>
     */
    
    public ApiResponse<MediaUploadResponse> executeWithHttpInfo() throws ApiException {
      return mediaUploadWithHttpInfo(mediaUploadRequest);
    }
    /**
     * Execute mediaUpload request (asynchronously)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
    <table summary="Response Details" border="1">
    <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
    <tr><td> 201 </td><td> The request has succeeded. </td><td>  -  </td></tr>
    <tr><td> 0 </td><td> The request has failed. </td><td>  -  </td></tr>
    </table>
     */
    public okhttp3.Call executeAsync(final ApiCallback<MediaUploadResponse> _callback) throws ApiException {
      return mediaUploadAsync(mediaUploadRequest, _callback);
    }
  }
  
}
