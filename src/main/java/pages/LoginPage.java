package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends CommonPage{
    private WebDriver driver;

    private String textFieldUserNameIdLocator = "org.wikipedia.alpha:id/login_username_text";
    private String textFieldPasswordXpathLocator = "//TextInputLayout[@resource-id='org.wikipedia.alpha:id/login_password_input']/android.widget.FrameLayout/android.widget.EditText";
    private String buttonLoginIdLocator = "org.wikipedia.alpha:id/login_button";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTextFieldUserName() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id(textFieldUserNameIdLocator)));
    }

    public WebElement getTextFieldPassword() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.xpath(textFieldPasswordXpathLocator)));

    }

    public WebElement getButtonLogin() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id(buttonLoginIdLocator)));
    }

    public boolean isPageOpen() {
        return getButtonLogin().isDisplayed();
    }
}
