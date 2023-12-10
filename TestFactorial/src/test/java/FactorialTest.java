import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    static ArrayList<BigInteger> testList;

    @DisplayName("Тестирование метода вычисления факториала")
    @BeforeAll
    public static void setUp() throws NumberFormatException, IOException {
        File first = new File("src/test/java/test.csv");
        String line;
        testList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(first))){
            while((line = reader.readLine()) != null) {
                testList.add(new BigInteger(line));
            }
        }
    }

    @Test
    public void testFactorial() {
        Factorial test = new Factorial();
        for (int i = 0; i <= 50; i++) {
            assertEquals(testList.get(i), test.result(i));
            System.out.println(i + "!" + "-> " + "expected=" +
                               testList.get(i) + "; actual=" +
                               test.result(i));
        }
        assertEquals(0, test.result(-1));
    }
}