import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    static ArrayList<BigInteger> testList;

    @BeforeAll
    static void setUp() throws IOException {
        File first = new File("src/test/resources/test.csv");
        String line;
        testList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(first))) {
            while((line = reader.readLine()) != null) {
                testList.add(new BigInteger(line));
            }
        }
    }

    @Test
    void resultTest() {
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