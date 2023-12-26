package Base;

import WBPages.CartPage;
import WBPages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestConfig {

    static Actions builder;
    private static WebDriver driver;

    public static MainPage getMainPage() {
        return new MainPage(driver);
    }

    public static CartPage getCartPage() {
        return new CartPage(driver);
    }

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        builder = new Actions(driver);
        driver.manage().window().maximize();
        driver.get("https://www.wildberries.ru/");
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.attributeContains(By.tagName("article"), "data-index", "0"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
