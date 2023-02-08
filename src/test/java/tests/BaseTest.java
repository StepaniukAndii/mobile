package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.SneakyThrows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import screens.HomeScreen;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;

public abstract class BaseTest {

    protected AppiumDriver driver;
    protected HomeScreen homeScreen;
    private AppiumDriverLocalService appiumServiceBuilder;

    @BeforeSuite
    public void setUpAppiumServer() {
        HashMap<String, String> environment = new HashMap<>();
        environment.put("ANDROID_HOME", "/home/asus/Android/Sdk");

        appiumServiceBuilder = new AppiumServiceBuilder()
                .usingPort(4723)
                .withIPAddress("0.0.0.0")
                .usingDriverExecutable(new File("/home/asus/.nvm/versions/node/v18.12.1/bin/node"))
                .withAppiumJS(new File("/home/asus/.nvm/versions/node/v18.12.1/bin/appium"))
                .withArgument(() -> "--base-path", "wd/hub")
                .withEnvironment(environment)
                .build();
        appiumServiceBuilder.start();
    }


    @BeforeMethod
    @SneakyThrows
    public void setUpDriver() {
        UiAutomator2Options automator2Options = new UiAutomator2Options();
        automator2Options.setApp("/home/asus/LearnProjects/mobail-autotests/src/ApiDemos-debug.apk");
        automator2Options.setDeviceName("sdk");

        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), automator2Options);

        homeScreen = new HomeScreen(driver);
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    @AfterSuite
    public void quitAppiumServer() {
        appiumServiceBuilder.stop();
    }
}
