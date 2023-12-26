package WBPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class  Cart {

    List<Product> cartComposition;
    WebDriver driver;
    private int totalAmount = 0;

    public Cart(WebDriver driver) {
        this.cartComposition = new ArrayList<>();
        this.driver = driver;
    }

    public int getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addProduct(WebElement changeProduct, By nameLocator, By priceLocator,String idAttribute) {
        Product prod = new Product(
                changeProduct.findElement(nameLocator).getText()
                        .replace("/ ", "").replace(".", ""),
                changeProduct.findElement(priceLocator).getText()
                        .replace(" ₽", "").replace(" ", ""),
                changeProduct.getAttribute(idAttribute)
        );
        cartComposition.add(prod);
    }

    public void addProduct(WebElement changeProduct, By nameLocator,
                           By priceLocator, By idLocator,String idAttribute) {
        Product prod = new Product(
                changeProduct.findElement(nameLocator).getText()
                        .replace("/ ", "").replace(".", ""),
                changeProduct.findElement(priceLocator).getText()
                        .replace(" ₽", "").replace(" ", ""),
                changeProduct.findElement(idLocator).getAttribute(idAttribute)
        );
        cartComposition.add(prod);
    }

    public int sumAllProductsPrice() {
        return cartComposition.stream().mapToInt(i -> Integer.parseInt(i.getPrice())).sum();
    }

    public List<Product> getCartComposition() {
        return this.cartComposition;
    }
}
