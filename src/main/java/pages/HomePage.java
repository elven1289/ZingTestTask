package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends CommonPage {
    private WebDriver driver;
    private WebElement innerTextElement = null;
    private WebElement searchElement = null;
    private WebElement buttonOptions = null;
    private WebElement buttonLogin = null;
    private WebElement labelAccountName = null;
    private WebElement labelAvatar = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchElement() {
        if (searchElement == null) {
            return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Search Wikipedia")));
        } else {
            return searchElement;
        }
    }

    public WebElement getInnerTextElement() {
        if (innerTextElement == null) {
            return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        } else {
            return innerTextElement;
        }
    }

    public WebElement getButtonOptions() {
        if (buttonOptions == null) {
            return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button")));
        } else {
            return buttonOptions;
        }
    }

    public WebElement getButtonLogin() {
        if (buttonLogin == null) {
            return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    ExpectedConditions.elementToBeClickable(AppiumBy.xpath(".//*[@text='Log in to Wikipedia']")));
        } else {
            return buttonLogin;
        }
    }

    public WebElement getLabelAccountName() {
        if (labelAccountName == null) {
            return new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                    ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_account_name")));
        } else {
            return labelAccountName;
        }
    }

    public boolean isUserLoggedIn() {
        try {
            this.getButtonOptions().click();
            return getLabelAccountName().isDisplayed();
        } catch (Throwable e) {
            return false;
        }
    }

    public WebElement getLabelAvatar() {
        if (labelAvatar == null) {
            return driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Avatar: The Last Airbender (2024 TV series)\"))"));
        } else {
            return labelAvatar;
        }
    }
}
