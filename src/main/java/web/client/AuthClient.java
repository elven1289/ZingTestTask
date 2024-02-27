package web.client;

import com.google.gson.Gson;
import io.restassured.response.Response;
import web.request.LoginRequest;
import web.response.LoginResponse;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthClient extends CommonClient {

    private String property = "authHost";

    public AuthClient() {
        hostProperty =  property;
        loadHost();
        headers.put("Content-Type", "application/json");
    }

    public AuthClient(Map<String, String> headers) {
        super(headers);
        hostProperty =  property;
        loadHost();
    }

    public int getLoginResponseCode(LoginRequest request) {
        return given().basePath(this.baseHost).headers(this.headers).when().body(new Gson().toJson(request)).post().getStatusCode();
    }

    public String getToken(LoginRequest request) {
        return new Gson().fromJson(given().basePath(this.baseHost).headers(this.headers).when().body(new Gson().toJson(request)).post().asString(), LoginResponse.class).getToken();
    }

    public LoginResponse getLoginResponse(LoginRequest request) {
        return new Gson().fromJson(given().basePath(this.baseHost).headers(this.headers).when().body(new Gson().toJson(request)).post().asString(), LoginResponse.class);
    }

    public Response getRestAssuredResponse(LoginRequest request) {
        return given().basePath(this.baseHost).headers(this.headers).when().body(new Gson().toJson(request)).post();
    }
}
