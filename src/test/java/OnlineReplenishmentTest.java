import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class  OnlineReplenishmentTest {

    static WebDriver driver;
    static WebElement buttonCookieCancel;
    WebElement iframeAfterClickContinue;
    WebElement moreAboutService;
    WebElement title;
    WebElement buttonContinue;
    List<WebElement> imagesPartners;
    List<WebElement> payFormList;
    Actions builder;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.className("cookie__cancel")));
        buttonCookieCancel = driver.findElement(By.className("cookie__cancel"));
        buttonCookieCancel.click();
    }

   @Test
   @Order(1)
   void testReplenishmentTitle () {
        title = driver.findElement(By.cssSelector(".pay__wrapper h2"));
        assertEquals("Онлайн пополнение\nбез комиссии",
               title.getText());
   }

   @Test
   @Order(2)
   void testReplenishmentLogoPartners() {
       imagesPartners =  driver.findElements(By.cssSelector(".pay__partners img"));
       assertAll(
               "Проверяем отображение логотипов партнеров:",
               () -> assertTrue(imagesPartners.get(0).isDisplayed(), "Visa"),
               () -> assertTrue(imagesPartners.get(1).isDisplayed(), "Verified By Visa"),
               () -> assertTrue(imagesPartners.get(2).isDisplayed(), "MasterCard"),
               () -> assertTrue(imagesPartners.get(3).isDisplayed(), "MasterCard Secure Code"),
               () -> assertTrue(imagesPartners.get(4).isDisplayed(), "Белкарт"),
               () -> assertTrue(imagesPartners.get(5).isDisplayed(), "МИР")
       );
   }

   @Test
   @Order(3)
   void testReplenishmentAboutService() {
       moreAboutService = driver.findElement(By.linkText("Подробнее о сервисе"));
       moreAboutService.click();
       assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"
               , driver.getCurrentUrl());
       driver.navigate().back();
   }

   @Test
   @Order(4)
   void testReplenishmentFields() {
       builder = new Actions(driver);
       buttonContinue = driver.findElement(By.className("button__default"));
       payFormList = driver.findElements(By.cssSelector(".pay-form.opened .input-wrapper"));
       builder.moveToElement(driver.findElement(By.cssSelector(".pay__wrapper")))
               .click(payFormList.get(0)).sendKeys("297777777")
               .click(payFormList.get(1)).sendKeys("499.99")
               .click(payFormList.get(2)).sendKeys("aqaTest@mail.com")
               .click(buttonContinue)
               .build().perform();
       new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-iframe")));
       iframeAfterClickContinue = driver.findElement(By.cssSelector(".bepaid-iframe"));
       assertTrue(iframeAfterClickContinue.isEnabled());
       assertTrue(iframeAfterClickContinue.isDisplayed());
   }

   @AfterAll
   static void tearDown() {
       driver.quit();
   }
}
