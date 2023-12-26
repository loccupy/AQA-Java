package WBPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private final By listNamesLocator = By.cssSelector(".good-info__good-name");
    private final By listPricesLocator = By.cssSelector(".list-item__price-new");
    private final By listProductsLocator = By.cssSelector(".accordion__list .accordion__list-item");
    private final By listIdLocator = By.cssSelector(".good-info__seller");
    private final By allSumLocator = By.cssSelector("p > span:nth-child(2) > span");
    private final WebDriver driver;
    private final Cart actualCart;
    private int totalAmount;

    public CartPage(WebDriver driver) {
        actualCart = new Cart(driver);
        this.driver = driver;
        WebElement allSumProducts = driver.findElement(allSumLocator);
        totalAmount = Integer.parseInt(allSumProducts.getText()
                .replace(" ","").replace("₽", ""));
    }

    public CartPage initActualCart() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> listProducts = driver.findElements(listProductsLocator);
        for(int i = listProducts.size() - 1; i >= 0; i--) {
            String idAttribute = "data-nm";
            actualCart.addProduct(
                    listProducts.get(i),
                    listNamesLocator,
                    listPricesLocator,
                    listIdLocator,
                    idAttribute);
        }
        WebElement allSumProducts = driver.findElement(allSumLocator);
        totalAmount = Integer.parseInt(allSumProducts.getText()
                .replace(" ","").replace("₽", ""));
        actualCart.setTotalAmount(totalAmount);
        return this;
    }

    public Cart getActualCart() {
        return this.actualCart;
    }
}
