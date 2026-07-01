package com.twitter.clientlib.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemXComDomainTest {

  @Test
  void normalizeProblemType_mapsXComProblemUrlsToTwitterCom() {
    assertEquals("https://api.twitter.com/2/problems/resource-not-found",
        Problem.normalizeProblemType("https://api.x.com/2/problems/resource-not-found"));
    assertEquals("ResourceNotFoundProblem",
        Problem.normalizeProblemType("ResourceNotFoundProblem"));
  }

  @Test
  void validateJsonObject_acceptsXComResourceNotFoundProblemType() {
    JsonObject jsonObj = JsonParser.parseString(
        "{\"title\":\"Not Found Error\",\"type\":\"https://api.x.com/2/problems/resource-not-found\","
            + "\"parameter\":\"pinned_tweet_id\",\"resource_id\":\"123\",\"resource_type\":\"tweet\","
            + "\"value\":\"123\"}").getAsJsonObject();

    assertDoesNotThrow(() -> Problem.validateJsonObject(jsonObj));
  }

  @Test
  void get2UsersMeResponse_validateJsonObject_acceptsXComErrorsInResponse() {
    JsonObject jsonObj = JsonParser.parseString(
        "{\"data\":{\"id\":\"123\",\"name\":\"The Herald\",\"username\":\"heraldscotland\"},"
            + "\"errors\":[{\"title\":\"Not Found Error\","
            + "\"type\":\"https://api.x.com/2/problems/resource-not-found\","
            + "\"parameter\":\"pinned_tweet_id\",\"resource_id\":\"123\",\"resource_type\":\"tweet\","
            + "\"value\":\"123\"}]}").getAsJsonObject();

    assertDoesNotThrow(() -> Get2UsersMeResponse.validateJsonObject(jsonObj));
  }
}
