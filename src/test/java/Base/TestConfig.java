package Base;
import CalculatorPageAttribyte.CalculatorPage;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestConfig {

    public static final String URL = "com.google.android.calculator";
    public static AndroidDriver driver;

    public CalculatorPage CalculatePage() {
        return new CalculatorPage(driver);
    }

    @BeforeAll
    public static void setUp() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("appium:platformName", "Android");
        capability.setCapability("appium:deviceName", "Pixel 7 API 30");
        capability.setCapability("appium:automationName", "UiAutomator2");
        capability.setCapability("noReset", "true");
        capability.setCapability("full-reset", false);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capability);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        driver.activateApp(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterAll
    public static void tearDownAll() {
        driver.terminateApp(URL);
    }
}
