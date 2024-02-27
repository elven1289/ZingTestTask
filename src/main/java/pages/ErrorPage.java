package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErrorPage extends CommonPage {

    private By buttonGoBackLocator = AppiumBy.id("org.wikipedia.alpha:id/view_wiki_error_button");

    private WebDriver driver;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonGoBackLocator() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(buttonGoBackLocator));
    }
}
