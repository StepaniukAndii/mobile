package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen<HomeScreen> {

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    private WebElement preference() {
        return elementToBeClickable(driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("Preference")));
    }

    public HomeScreen clickPreference() {
        preference().click();
        return this;
    }
}
