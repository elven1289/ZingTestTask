package tests;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import support.UserRepository;
import support.entities.User;
import web.client.AuthClient;
import web.request.LoginRequest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AuthTest {

    public AuthClient authClient = new AuthClient();

    /**
     * Before test hook that is used to set up values for test execution
     */
    @BeforeMethod
    public void URLsetup() throws IOException {
        Properties prop = new Properties();
        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("backendConfig.properties"));
        RestAssured.baseURI = prop.getProperty("baseUrl");
    }

    // Positive auth test
    @Test
    public void authTest() throws FileNotFoundException {
        UserRepository userRepository = new UserRepository();
        User validUser = userRepository.getUserByTag("valid_backend_user");
        LoginRequest request = new LoginRequest();
        request.username = validUser.username;
        request.password = validUser.password;
        Assert.assertEquals(authClient.getLoginResponseCode(request), 200, "Returned status code is not valid");
    }

    // Negative auth test
    @Test
    public void authTestNegative() throws FileNotFoundException {
        UserRepository userRepository = new UserRepository();
        User validUser = userRepository.getUserByTag("valid_backend_user");
        LoginRequest request = new LoginRequest();
        request.username = validUser.username;
        request.password = "123";
        Assert.assertEquals(authClient.getLoginResponseCode(request), 400, "Returned status code is not valid");
        Assert.assertEquals(authClient.getLoginResponse(request).getToken(), null, "Failed auth request returns token");
    }
}
