package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErrorPage extends CommonPage {

    private String buttonGoBackIdLocator = "org.wikipedia.alpha:id/view_wiki_error_button";

    private WebDriver driver;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonGoBackLocator() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(AppiumBy.id(buttonGoBackIdLocator)));


    }
}
