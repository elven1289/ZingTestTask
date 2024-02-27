package web.client;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Client class that is used to communicate with auth/product API
 */
public class ProductsClient extends CommonClient {
    private String property = "productsHost";

    public ProductsClient() {
        hostProperty = property;
        loadHost();
        headers.put("Content-Type", "application/json");
    }

    public ProductsClient(Map<String, String> headers) {
        super(headers);
        hostProperty = property;
        loadHost();
    }

    public ProductsClient(String token) {
        hostProperty = property;
        loadHost();
        headers.put("Authorization", "Bearer " + token);
    }

    public void updateToken(String token) {
        headers.put("Authorization", "Bearer " + token);
    }

    public Response getRestAssuredResponse() {
        return given().basePath(this.baseHost).headers(this.headers).when().get();
    }
}
