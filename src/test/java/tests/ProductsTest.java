package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import support.UserRepository;
import support.entities.User;
import web.client.AuthClient;
import web.client.ProductsClient;
import web.request.LoginRequest;
import web.response.products.ProductsResponse;

import java.io.IOException;
import java.util.Properties;

public class ProductsTest {
    public AuthClient authClient = new AuthClient();
    public ProductsClient productsClient = new ProductsClient();

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
        productsClient.updateToken(token);
    }

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{{19, "Skin Beauty Serum."}, {20, "Freckle Treatment Cream- 15gm"}};
    }

    @Test(dataProvider = "data-provider")
    public void productsResponseTest(int testId, String name) {
        Response response = productsClient.getRestAssuredResponse();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not valid");
        Assert.assertEquals(ProductsResponse.parseJson(response.asString()).products.stream().filter(p -> p.id == testId).findFirst().get().title, name, "Value with id " + testId + " has invalid name");
    }

    @Test
    public void productsResponseNegative() {
        productsClient.updateToken("123");
        Response response = productsClient.getRestAssuredResponse();
        Assert.assertEquals(response.getStatusCode(), 401, "Unexpected status code for a request with invalid auth token");
    }


}
