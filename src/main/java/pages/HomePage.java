package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends CommonPage {
    private WebDriver driver;
    private By buttonOptionsLocator = AppiumBy.id("org.wikipedia.alpha:id/menu_overflow_button");
    private By buttonLoginLocator = AppiumBy.xpath(".//*[@text='Log in to Wikipedia']");
    private By labelAccountNameLocator = AppiumBy.id("org.wikipedia.alpha:id/explore_overflow_account_name");
    private By labelAvatarLocator = new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Avatar: The Last Airbender (2024 TV series)\"))");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getButtonOptions() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.elementToBeClickable(buttonOptionsLocator));
    }

    public WebElement getButtonLogin() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(buttonLoginLocator));
    }

    public WebElement getLabelAccountName() {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                ExpectedConditions.elementToBeClickable(labelAccountNameLocator));
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
        return driver.findElement(labelAvatarLocator);
    }
}
