package tests;

import lombok.SneakyThrows;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

public class TestMobile extends BaseTest {

    @SneakyThrows
    @Test
    public void runMessagesTest() {
        homeScreen
                .clickPreference();
    }
}
