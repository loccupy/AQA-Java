package CalculatorPageAttribyte;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalculatorPage {

    public static AndroidDriver driver;
    private final String URL = "com.google.android.calculator";

    By keyPlusLocator = By.id(URL + ":id/op_add");
    By keyMinusLocator = By.id(URL + ":id/op_sub");
    By keyMulLocator = By.id(URL + ":id/op_mul");
    By keyDivLocator = By.id(URL + ":id/op_div");
    By equal = By.id(URL + ":id/eq");
    By clear = By.id(URL + ":id/clr");
    By zero = By.id(URL + ":id/digit_0");
    By one = By.id(URL + ":id/digit_1");
    By two = By.id(URL + ":id/digit_2");
    By three = By.id(URL + ":id/digit_3");
    By fourth = By.id(URL + ":id/digit_4");
    By five = By.id(URL + ":id/digit_5");
    By six = By.id(URL + ":id/digit_6");
    By seven = By.id(URL + ":id/digit_7");
    By eight = By.id(URL + ":id/digit_8");
    By nine = By.id(URL + ":id/digit_9");
    By result = By.id(URL + ":id/result_final");
    By resultPreview = By.id(URL + ":id/result_preview");
    By formula = By.id(URL + ":id/formula");

    public CalculatorPage(AndroidDriver driver) {
        CalculatorPage.driver = driver;
    }
    public CalculatorPage clickPlus() {
        driver.findElement(keyPlusLocator).click();
        return this;
    }

    public CalculatorPage clickMinus() {
        driver.findElement(keyMinusLocator).click();
        return this;
    }

    public CalculatorPage clickMul() {
        driver.findElement(keyMulLocator).click();
        return this;
    }

    public CalculatorPage clickDiv() {
        driver.findElement(keyDivLocator).click();
        return this;
    }

    public CalculatorPage clickEqual() {
        driver.findElement(equal).click();
        return this;
    }

    public CalculatorPage clickClear() {
        driver.findElement(clear).click();
        return this;
    }

    public CalculatorPage clickZero() {
        driver.findElement(zero).click();
        return this;
    }

    public CalculatorPage clickOne() {
        driver.findElement(one).click();
        return this;
    }

    public CalculatorPage clickTwo() {
        driver.findElement(two).click();
        return this;
    }

    public CalculatorPage clickThree() {
        driver.findElement(three).click();
        return this;
    }

    public CalculatorPage clickFourth() {
        driver.findElement(fourth).click();
        return this;
    }

    public CalculatorPage clickFive() {
        driver.findElement(five).click();
        return this;
    }

    public CalculatorPage clickSix() {
        driver.findElement(six).click();
        return this;
    }

    public CalculatorPage clickSeven() {
        driver.findElement(seven).click();
        return this;
    }

    public CalculatorPage clickEight() {
        driver.findElement(eight).click();
        return this;
    }

    public CalculatorPage clickNine() {
        driver.findElement(nine).click();
        return this;
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }

    public String getFormula() {
        return driver.findElement(formula).getText();
    }

    public String getResultPreview() {
        return driver.findElement(resultPreview).getText();
    }
}
