import Base.TestConfig;
import WBPages.Cart;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AppWildberriesTest extends TestConfig {

    Cart expectedCart;
    Cart actualCart;

    @Test
    void test() throws InterruptedException {
        expectedCart= getMainPage().addProductExpectedCart(2).addProductExpectedCart(5)
                .addProductExpectedCart(10).addProductExpectedCart(16)
                .addProductExpectedCart(25).goToCart().getExpectedCart();
        actualCart =  getCartPage().initActualCart().getActualCart();
        assertAll(
                "Сравниваем суммы цен продуктов:",
                () -> assertEquals(actualCart.sumAllProductsPrice(), expectedCart.sumAllProductsPrice(),
                        "Сумма на главной странице и сумма всех продуктов в корзине"),
                () -> assertEquals(actualCart.getTotalAmount(), actualCart.sumAllProductsPrice(),
                        "Сумма на главной странице и общая сумма в корзине"),
                () -> assertEquals(actualCart.getTotalAmount(), expectedCart.sumAllProductsPrice(),
                        "Суммы всех продуктов в корзине и общая в корзине")
        );

        assertAll(
                "Сравниваем добавленные товары и то, что оказалось в корзине:",
                () -> assertTrue(actualCart.getCartComposition().get(0)
                        .equalsProduct(expectedCart.getCartComposition().get(0)), "1"),
                () -> assertTrue(actualCart.getCartComposition().get(1)
                        .equalsProduct(expectedCart.getCartComposition().get(1)), "2"),
                () -> assertTrue(actualCart.getCartComposition().get(2)
                        .equalsProduct(expectedCart.getCartComposition().get(2)), "3"),
                () -> assertTrue(actualCart.getCartComposition().get(3)
                        .equalsProduct(expectedCart.getCartComposition().get(3)), "4"),
                () -> assertTrue(actualCart.getCartComposition().get(4)
                        .equalsProduct(expectedCart.getCartComposition().get(4)), "5")
        );
    }
}
