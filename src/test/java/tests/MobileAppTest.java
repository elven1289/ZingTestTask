package tests;

import driver.BrowserStackDriverProvider;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ErrorPage;
import pages.HomePage;
import pages.LoginPage;
import steps.LoginSteps;
import support.PagesSupport;
import support.UserRepository;
import support.entities.User;

import java.io.FileNotFoundException;


public class MobileAppTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ErrorPage errorPage;
    private User validUser;

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        UserRepository userRepository = new UserRepository();
        validUser = userRepository.getUserByTag("valid_mobile_user");
        driver = BrowserStackDriverProvider.getDriver();
        PagesSupport.reinitializePages(this, driver);
    }

    @AfterMethod
    public void tearDown() {
        // Invoke driver.quit() to indicate that the test is completed.
        // Otherwise, it will appear as timed out on BrowserStack.\
        BrowserStackDriverProvider.tearDown();
    }

    @Test
    public void LoginTest() {
        LoginSteps.getToLoginPage(homePage);
        LoginSteps.loginWithCredentials(loginPage, validUser.username, validUser.password);
        Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in");
    }

    @Test
    public void NegativeLoginTest() {
        LoginSteps.getToLoginPage(homePage);
        LoginSteps.loginWithCredentials(loginPage, validUser.username, "123");
        Assert.assertTrue(loginPage.isPageOpen(), "Login was unsuccessfull");
    }

    @Test
    public void NegativeLoginTest_Failed() {
        LoginSteps.getToLoginPage(homePage);
        LoginSteps.loginWithCredentials(loginPage, validUser.username, "123");
        Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in");
    }

    @Test
    public void scrollTest() {
        homePage.getLabelAvatar().click();
        Assert.assertTrue(errorPage.getButtonGoBackLocator().isDisplayed());
    }
}
