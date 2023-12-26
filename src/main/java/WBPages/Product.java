package WBPages;

import java.util.Objects;

public class Product {

    private final String name;
    private final String price;
    private final String id;

    public Product(String name, String price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public boolean equalsProduct(Product anotherProduct) {
        return Objects.equals(anotherProduct.id, this.id) && anotherProduct.name.equals(this.name)
                && anotherProduct.price.equals(this.price);
    }
}
