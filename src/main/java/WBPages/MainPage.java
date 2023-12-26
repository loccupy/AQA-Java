package WBPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    private final By nameLocator = By.cssSelector(".product-card__name");
    private final By priceLocator = By.cssSelector(".price__lower-price");
    private final By goToCartLocator = By.cssSelector(".navbar-pc__item.j-item-basket");
    private final By addToCartLocator = By.linkText("В корзину");
    private final WebDriver driver;
    WebElement buttonAddToCart;
    private final List<WebElement> listProducts;
    Cart expectedCart;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        By listProductLocator = By.tagName("article");
        this.listProducts = driver.findElements(listProductLocator);
        expectedCart = new Cart(driver);
    }

    public MainPage addProductExpectedCart(int position) {
        WebElement cardProduct = listProducts.get(position);
        new Actions(driver).moveToElement(cardProduct).build().perform();
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfAllElements(cardProduct));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfAllElements(driver.findElement(addToCartLocator)));
        buttonAddToCart = driver.findElement(addToCartLocator);
        new Actions(driver).click(buttonAddToCart).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> sizesPopUp = driver.findElements(By.cssSelector(".popup-list-of-sizes li"));
        if (!sizesPopUp.isEmpty()) {
            new Actions(driver).click(sizesPopUp.get(0)).build().perform();
        }
        String idAttribute = "data-nm-id";
        expectedCart.addProduct(listProducts.get(position), nameLocator, priceLocator, idAttribute);
        return this;
    }

    public MainPage goToCart() {
        WebElement goToCart = driver.findElement(goToCartLocator);
        new Actions(driver).click(goToCart)
                .build().perform();
        return this;
    }

    public Cart getExpectedCart() {
        return this.expectedCart;
    }
}
