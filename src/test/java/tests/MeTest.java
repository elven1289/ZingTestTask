package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import support.UserRepository;
import support.entities.User;
import web.client.AuthClient;
import web.client.MeClient;
import web.request.LoginRequest;
import web.response.me.MeResponse;

import java.io.IOException;
import java.util.Properties;

public class MeTest {
    public AuthClient authClient = new AuthClient();
    public MeClient meClient = new MeClient();

    @BeforeMethod
    public void setup() throws IOException {
        Properties prop = new Properties();
        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("backendConfig.properties"));
        RestAssured.baseURI = prop.getProperty("baseUrl");

        UserRepository userRepository = new UserRepository();
        User validUser = userRepository.getUserByTag("valid_backend_user");
        LoginRequest request = new LoginRequest();
        request.username = validUser.username;
        request.password = validUser.password;

        String token = authClient.getToken(request);
        meClient.updateToken(token);
    }

    @Test
    public void meResponseTest() {
        Response response = meClient.getRestAssuredResponse();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not valid");
        Assert.assertEquals(MeResponse.parseJson(response.asString()).company.address.city, "Salinas", "City is not valid");
    }

    @Test
    public void meResponseNegative() {
        meClient.updateToken("123");
        Response response = meClient.getRestAssuredResponse();
        Assert.assertEquals(response.getStatusCode(), 401, "Unexpected status code for a request with invalid auth token");
    }

    @Test
    public void meResponseNegative_failed() {
        Response response = meClient.getRestAssuredResponse();
        Assert.assertEquals(response.getStatusCode(), 401, "Unexpected status code for a request with invalid auth token");
    }
}