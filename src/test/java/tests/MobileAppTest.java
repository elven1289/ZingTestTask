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
import support.ScreenshotListener;


public class MobileAppTest {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ErrorPage errorPage;


    @BeforeMethod
    public void setUp() {
     //   driver = BrowserStackDriverProvider.getDriver();
     //   PagesSupport.reinitializePages(this, driver);
    }

    @AfterMethod
    public void tearDown() {
        // Invoke driver.quit() to indicate that the test is completed.
        // Otherwise, it will appear as timed out on BrowserStack.\
       // BrowserStackDriverProvider.tearDown();
    }

 //  @Test
 //  public void LoginTest() {
 //      //    LoginSteps.getToLoginPage(homePage);
 //      //    LoginSteps.loginWithCredentials(loginPage, "Zhanattestaccount", "G6@G$xRyhPwL*@%8&w9x");
 //      //    Assert.assertTrue("User is not logged in", homePage.isUserLoggedIn());
 //  }

 //  @Test
 //  public void NegativeLoginTest() {
 //      //   LoginSteps.getToLoginPage(homePage);
 //      //   LoginSteps.loginWithCredentials(loginPage, "Zhanattestaccount", "123");
 //      //   Assert.assertTrue("Login was unsuccessfull", loginPage.isPageOpen());
 //  }

 //  @Test
 //  public void NegativeLoginTest_Failed() {
 //      LoginSteps.getToLoginPage(homePage);
 //      LoginSteps.loginWithCredentials(loginPage, "Zhanattestaccount", "123");
 //      Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in");
 //  }

  @Test
  public void scrollTest() {
      // Assert.assertTrue(false);
      //   homePage.getLabelAvatar().click();
      //   Assert.assertTrue(errorPage.getButtonGoBackLocator().isDisplayed());
  }
}
