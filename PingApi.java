package io.github.api;

import io.restassured.response.Response;

import static io.github.util.ApiEndpoints.BASE_URL;
import static io.github.util.ApiEndpoints.PING_ENDPOINT;
import static io.restassured.RestAssured.given;

/**
 * @author 
 */
public final class PingApi {
    private PingApi() {}

    public static Response healthCheck() {
        return given().when().get(BASE_URL + PING_ENDPOINT);
    }
}
