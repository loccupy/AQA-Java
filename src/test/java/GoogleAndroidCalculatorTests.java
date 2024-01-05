import Base.TestConfig;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GoogleAndroidCalculatorTests extends TestConfig{

    @Test
    @DisplayName("Вычитание с отрицательным числом в результате")
    void test0() {
        String actual = CalculatePage().clickFourth().clickMinus()
                .clickFive().clickEqual().getResult().replace("−", "-");
        assertEquals("-1",  actual);
    }

    @Test
    @DisplayName("Вычитание с положительным числом в результате")
    void test1() {
        String actual = CalculatePage().clickClear().clickThree()
                .clickMinus().clickTwo().clickEqual().getResult();
        assertEquals("1",  actual);
    }

    @Test
    @DisplayName("Сложение")
    void test2() {
        String actual = CalculatePage().clickClear().clickSix().clickSix()
                .clickPlus().clickFourth().clickFourth().clickEqual().getResult();
        assertEquals("110", actual);
    }

    @Test
    @DisplayName("Умножение")
    void test3() {
        String actual = CalculatePage().clickClear().clickEight().clickMul()
                .clickNine().clickEqual().getResult();
        assertEquals("72", actual);
    }

    @Test
    @DisplayName("Деление")
    void test4() {
        String actual = CalculatePage().clickClear().clickMinus().clickSeven()
                .clickSeven().clickDiv().clickMinus().clickOne().clickOne().clickEqual().getResult();
        assertEquals("7",actual);
    }

    @Test
    @DisplayName("Деление на ноль")
    void test5() {
        String actual = CalculatePage().clickClear().clickMinus().clickSeven()
                .clickSeven().clickDiv().clickZero().clickEqual().getFormula();
        assertEquals("−77÷0", actual);
        assertEquals("Can't divide by 0", CalculatePage().getResultPreview());
    }
}