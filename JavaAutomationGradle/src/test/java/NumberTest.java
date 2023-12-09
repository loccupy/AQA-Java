import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @Test
    void sum() {
        Number number = new Number();
        int actual = number.sum(5);
        int expected = 15;
        assertEquals(expected, actual);
    }
}