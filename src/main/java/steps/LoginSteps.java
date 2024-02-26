package steps;

import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {

    public static void getToLoginPage(HomePage homePage){
        homePage.getButtonOptions().click();
        homePage.getButtonLogin().click();
    }
    public static void loginWithCredentials(LoginPage loginPage, String userName, String password) {
        loginPage.getTextFieldUserName().sendKeys(userName);
        loginPage.getTextFieldPassword().sendKeys(password);
        loginPage.getButtonLogin().click();
    }
}
