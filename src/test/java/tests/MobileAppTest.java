package tests;

import driver.BrowserStackDriverProvider;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ErrorPage;
import pages.HomePage;
import pages.LoginPage;
import steps.LoginSteps;
import support.PagesSupport;


public class MobileAppTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ErrorPage errorPage;

    @Before
    public void setUp() {
       // driver = new BrowserStackDriverProvider().getDriver();
       // PagesSupport.reinitializePages(this, driver);
    }

    @After
    public void tearDown() {
        // Invoke driver.quit() to indicate that the test is completed.
        // Otherwise, it will appear as timed out on BrowserStack.
        // driver.quit();
    }

    @Test
    public void LoginTest() {
    //    LoginSteps.getToLoginPage(homePage);
    //    LoginSteps.loginWithCredentials(loginPage, "Zhanattestaccount", "G6@G$xRyhPwL*@%8&w9x");
    //    Assert.assertTrue("User is not logged in", homePage.isUserLoggedIn());
    }

    @Test
    public void NegativeLoginTest() {
     //   LoginSteps.getToLoginPage(homePage);
     //   LoginSteps.loginWithCredentials(loginPage, "Zhanattestaccount", "123");
     //   Assert.assertTrue("Login was unsuccessfull", loginPage.isPageOpen());
    }

    @Test
    public void NegativeLoginTest_Failed() {
      //  LoginSteps.getToLoginPage(homePage);
      //  LoginSteps.loginWithCredentials(loginPage, "Zhanattestaccount", "123");
      //  Assert.assertTrue("User is not logged in", homePage.isUserLoggedIn());
    }

    @Test
    public void scrollTest() {
     //   homePage.getLabelAvatar().click();
     //   Assert.assertTrue(errorPage.getButtonGoBackLocator().isDisplayed());
    }
}
