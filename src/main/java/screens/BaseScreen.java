package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseScreen<T> {

    protected AppiumDriver driver;
    protected WebDriverWait webDriverWait;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    protected WebElement elementToBeClickable(WebElement element) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
