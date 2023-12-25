import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OnlineReplenishmentTest {

    static WebDriver driver;
    static Actions builder;
    static WebElement buttonHeader;
    static WebElement  buttonContinue;
    WebElement iframePayment;
    WebElement googleButton, yandexButton;
    WebElement iconVisa, iconMasterCard, iconBelkart, iconMirAndMaestro;
    WebElement moneySum, moneySumOnButton, phoneNumber;
    static List<WebElement> listDropDown;
    List<WebElement> cardDetailsList;
    List<WebElement> payFormList;
    String locatorPayFormListStr = ".pay-form.opened .input-wrapper";

    static void waitClickable(int second, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(second))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    boolean examPlaceholderAndLabel(WebElement element, String placeholder, String label) {
        if (label.isEmpty()) {
            return placeholder.equals(element.findElement(By.tagName("input")).getAttribute("placeholder"));
        }
        return placeholder.equals(element.findElement(By.tagName("input")).getAttribute("placeholder"))
                && label.equals(element.getText());
    }

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        waitClickable(5, By.className("cookie__cancel"));
        driver.findElement(By.className("cookie__cancel")).click();
        builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.cssSelector("div.pay__wrapper")));
    }

    @Test
    @Order(1)
    void testReplenishOptionDropDown() {
        buttonHeader = driver.findElement(By.className("select__header"));
        listDropDown = driver.findElements(By.cssSelector("p.select__option"));
        builder.click(buttonHeader).build().perform();
        waitClickable(3, By.cssSelector(".select__list"));
        assertAll(
                "Проверяем корректность текста в выпадающем списке:",
                () -> assertEquals("Услуги связи", listDropDown.get(0).getText()),
                () -> assertEquals("Домашний интернет", listDropDown.get(1).getText()),
                () -> assertEquals("Рассрочка", listDropDown.get(2).getText()),
                () -> assertEquals("Задолженность", listDropDown.get(3).getText())
        );
    }

    @Test
    @Order(2)
    void testPayFormFirstList() {
        payFormList = driver.findElements(By.cssSelector(locatorPayFormListStr));
        assertAll(
                "Проверяем корректность отображение текста в PayForm *Услуги связи*:",
                () -> assertEquals("Услуги связи", buttonHeader.getText()),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(0),
                        "Номер телефона", "+375")),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(1), "Сумма", "Руб.")),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(2),
                        "E-mail для отправки чека", ""))
        );
        payFormList.clear();
    }

    @Test
    @Order(3)
    void testPayFormSecondList() {
        builder.click(listDropDown.get(1)).build().perform();
        payFormList = driver.findElements(By.cssSelector(locatorPayFormListStr));
        assertAll(
                "Проверяем корректность отображение текста в PayForm *Домашний интернет*:",
                () -> assertEquals("Домашний интернет", buttonHeader.getText()),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(0), "Номер абонента", "+375")),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(1), "Сумма", "Руб.")),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(2),
                        "E-mail для отправки чека", ""))
        );
        payFormList.clear();
    }

    @Test
    @Order(4)
    void testPayFormThirdList() {
        builder.click(buttonHeader).build().perform();
        waitClickable(5, By.cssSelector("li:nth-child(3) > p"));
        builder.click(listDropDown.get(2)).build().perform();
        payFormList= driver.findElements(By.cssSelector(locatorPayFormListStr));
        assertAll(
                "Проверяем корректность отображение текста в PayForm *Рассрочка*:",
                () -> assertEquals("Рассрочка", buttonHeader.getText()),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(0),
                        "Номер счета на 44", "")),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(1), "Сумма", "Руб.")),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(2),
                        "E-mail для отправки чека", ""))
        );
        payFormList.clear();
    }

    @Test
    @Order(5)
    void testPayFormForthList() {
        builder.click(buttonHeader).build().perform();
        waitClickable(5, By.cssSelector("li:nth-child(4) > p"));
        builder.click(listDropDown.get(3)).build().perform();
        payFormList = driver.findElements(By.cssSelector(locatorPayFormListStr));
        assertAll(
                "Проверяем корректность отображение текста в PayForm *Задолженность*:",
                () -> assertEquals("Задолженность", buttonHeader.getText()),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(0),
                        "Номер счета на 2073", "")),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(1), "Сумма", "Руб.")),
                () -> assertTrue(examPlaceholderAndLabel(payFormList.get(2),
                        "E-mail для отправки чека", ""))
        );
        payFormList.clear();
        builder.click(buttonHeader).build().perform();
        waitClickable(5, By.cssSelector("li:nth-child(1) > p"));
        builder.click(listDropDown.get(0)).build().perform();
    }

    @Test
    @Order(6)
    void testReplenishAfterContinue() {
        String enteredPhoneNumber = "297777777";
        Double enteredSum = 166.65;
        String enteredSumStr = String.format("%.6s", enteredSum);
        buttonContinue = driver.findElement(By.cssSelector(".button__default"));
        payFormList = driver.findElements(By.cssSelector(locatorPayFormListStr));
        waitClickable(5, By.cssSelector(".button__default"));
        builder.click(payFormList.get(0)).sendKeys(enteredPhoneNumber)
                .click(payFormList.get(1)).sendKeys(enteredSumStr)
                .click(payFormList.get(2)).sendKeys("aqa@mail.com")
                .click(buttonContinue)
                .build().perform();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bepaid-iframe")));
        iframePayment = driver.findElement(By.cssSelector(".bepaid-iframe"));
        driver.switchTo().frame(iframePayment);
        waitClickable(5, By.cssSelector(".header__payment-amount"));
        moneySum = driver.findElement(By.cssSelector(".header__payment-amount"));
        moneySumOnButton = driver.findElement((By.cssSelector(".colored.disabled")));
        phoneNumber = driver.findElement(By.cssSelector(".header__payment-info"));
        cardDetailsList = driver.findElements(By.cssSelector(".card label"));
        assertAll(
                "Проверяем корректность отображения текста в незаполненных полях меню оплаты:",
                () -> assertEquals(enteredSumStr + " BYN", moneySum.getText()),
                () -> assertEquals("Оплатить " + enteredSumStr + " BYN", moneySumOnButton.getText()),
                () -> assertEquals("Оплата: Услуги связи Номер:375"
                        + enteredPhoneNumber, phoneNumber.getText()),
                () -> assertEquals("Номер карты", cardDetailsList.get(0).getText()),
                () -> assertEquals("Срок действия", cardDetailsList.get(1).getText()),
                () -> assertEquals("CVC", cardDetailsList.get(2).getText()),
                () -> assertEquals("Имя держателя (как на карте)", cardDetailsList.get(3).getText())
        );
    }

    @Test
    @Order(7)
    void testReplenishDisplayedIcons() {
        googleButton = driver.findElement(By.className("gpay-button"));
        yandexButton = driver.findElement(By.className("ya-pay-button"));
        iconMasterCard = driver.findElement(By.cssSelector(".icons-container > div > div > img:nth-child(1)"));
        iconVisa = driver.findElement(By.cssSelector(".icons-container > div > div > img:nth-child(2)"));
        iconBelkart = driver.findElement(By.cssSelector(".icons-container > div > div > img:nth-child(3)"));
        iconMirAndMaestro = driver.findElement(By.cssSelector("div.icons-container > div > div > div"));
        assertAll(
                "Проверяем наличие иконок платежных систем:",
                () -> assertTrue(googleButton.isDisplayed(), "GooglePay"),
                () -> assertTrue(yandexButton.isDisplayed(), "YandexPay"),
                () -> assertTrue(iconMasterCard.isDisplayed(), "MasterCard"),
                () -> assertTrue(iconVisa.isDisplayed(), "Visa"),
                () -> assertTrue(iconBelkart.isDisplayed(), "Belkart"),
                () -> assertTrue(iconMirAndMaestro.isDisplayed(), "Mir And Maestro")
        );
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
