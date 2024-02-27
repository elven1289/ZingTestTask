package web.client;

import com.google.gson.Gson;
import io.restassured.response.Response;
import web.response.me.MeResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Client class that is used to communicate with auth/me API
 */
public class MeClient extends CommonClient {

    private String property = "meHost";

    public MeClient() {
        hostProperty = property;
        loadHost();
        headers.put("Content-Type", "application/json");
    }

    public MeClient(Map<String, String> headers) {
        super(headers);
        hostProperty = property;
        loadHost();
    }

    public MeClient(String token) {
        hostProperty = property;
        loadHost();
        headers.put("Authorization", "Bearer " + token);
    }

    public void updateToken(String token) {
        headers.put("Authorization", "Bearer " + token);
    }

    public MeResponse getMeResponse() {
        return new Gson().fromJson(given().basePath(this.baseHost).headers(this.headers).when().get().asString(), MeResponse.class);
    }

    public Response getRestAssuredResponse() {
        return given().basePath(this.baseHost).headers(this.headers).when().get();
    }
}
