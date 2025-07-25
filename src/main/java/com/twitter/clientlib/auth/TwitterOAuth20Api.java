/*
Copyright 2020 Twitter, Inc.
SPDX-License-Identifier: Apache-2.0

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
https://openapi-generator.tech
Do not edit the class manually.
*/


package com.twitter.clientlib.auth;

import com.github.scribejava.core.builder.api.DefaultApi20;


public class TwitterOAuth20Api extends DefaultApi20 {
  protected TwitterOAuth20Api() {
  }

  public static TwitterOAuth20Api instance() {
    return TwitterOAuth20Api.InstanceHolder.INSTANCE;
  }

  public String getAccessTokenEndpoint() {
    return "https://api.x.com/2/oauth2/token";
  }

  protected String getAuthorizationBaseUrl() {
    return "https://x.com/i/oauth2/authorize";
  }

  public String getRevokeTokenEndpoint() {
    return "https://api.x.com/2/oauth2/revoke";
  }

  private static class InstanceHolder {
    private static final TwitterOAuth20Api INSTANCE = new TwitterOAuth20Api();

    private InstanceHolder() {
    }
  }
}
