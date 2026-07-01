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
*/

package com.twitter.clientlib.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.twitter.clientlib.JSON;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProblemXComDomainTest {

  @BeforeAll
  static void initializeGson() {
    new JSON();
  }

  private static final String X_COM_RESOURCE_NOT_FOUND_ERROR =
      "{\"title\":\"Not Found Error\",\"type\":\"https://api.x.com/2/problems/resource-not-found\","
          + "\"parameter\":\"pinned_tweet_id\",\"resource_id\":\"123\",\"resource_type\":\"tweet\","
          + "\"value\":\"123\"}";

  private static final String HERALD_USER_LOOKUP_RESPONSE =
      "{\"data\":{\"id\":\"123\",\"name\":\"The Herald\",\"username\":\"heraldscotland\"},"
          + "\"errors\":[" + X_COM_RESOURCE_NOT_FOUND_ERROR + "]}";

  @Test
  void normalizeProblemType_mapsXComProblemUrlsToTwitterCom() {
    assertEquals("https://api.twitter.com/2/problems/resource-not-found",
        Problem.normalizeProblemType("https://api.x.com/2/problems/resource-not-found"));
    assertEquals("ResourceNotFoundProblem",
        Problem.normalizeProblemType("ResourceNotFoundProblem"));
  }

  @Test
  void validateJsonObject_acceptsXComResourceNotFoundProblemType() {
    JsonObject jsonObj = JsonParser.parseString(X_COM_RESOURCE_NOT_FOUND_ERROR).getAsJsonObject();

    assertDoesNotThrow(() -> Problem.validateJsonObject(jsonObj));
  }

  @Test
  void problem_fromJson_deserializesXComResourceNotFoundProblem() throws IOException {
    Problem problem = Problem.fromJson(X_COM_RESOURCE_NOT_FOUND_ERROR);

    assertInstanceOf(ResourceNotFoundProblem.class, problem);
    ResourceNotFoundProblem notFound = (ResourceNotFoundProblem) problem;
    assertEquals("pinned_tweet_id", notFound.getParameter());
    assertEquals("123", notFound.getResourceId());
    assertEquals(ResourceNotFoundProblem.ResourceTypeEnum.TWEET, notFound.getResourceType());
  }

  @Test
  void get2UsersMeResponse_fromJson_deserializesXComErrorsInResponse() throws IOException {
    Get2UsersMeResponse response = Get2UsersMeResponse.fromJson(HERALD_USER_LOOKUP_RESPONSE);

    assertNotNull(response.getData());
    assertEquals("heraldscotland", response.getData().getUsername());
    assertNotNull(response.getErrors());
    assertEquals(1, response.getErrors().size());

    Problem error = response.getErrors().get(0);
    assertInstanceOf(ResourceNotFoundProblem.class, error);
    ResourceNotFoundProblem notFound = (ResourceNotFoundProblem) error;
    assertEquals("pinned_tweet_id", notFound.getParameter());
    assertEquals("123", notFound.getResourceId());
    assertEquals(ResourceNotFoundProblem.ResourceTypeEnum.TWEET, notFound.getResourceType());
  }
}
