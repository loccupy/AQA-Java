import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

import static org.testng.Assert.*;

public class FactorialTest {

    static ArrayList<BigInteger> testList;

    @BeforeMethod
    public void setUp() throws IOException {
        File first = new File("src/test/TestResources/test.csv");
        String line;
        testList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(first))) {
            while ((line = reader.readLine()) != null) {
                testList.add(new BigInteger(line));
            }
        }
    }

    @Test
    public void testResult() {
        Factorial fact = new Factorial();
        for (int i = 0; i <= 50; i++) {
            assertEquals(testList.get(i), fact.result(i));
            System.out.println(i + "!" + "-> " + "expected=" +
                    testList.get(i) + "; actual=" +
                    fact.result(i));
        }
        assertEquals(0, fact.result(-1));
    }
}