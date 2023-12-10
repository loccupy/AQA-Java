import java.math.BigInteger;
import java.util.stream.IntStream;

public class Factorial {

    public Object result(int numb) {
        if(numb < 0) {
            System.out.println("Используйте только положительные числа!");
            return 0;
        } else  if (numb < 2) {
            return BigInteger.ONE;
        }
        return IntStream.rangeClosed(2, numb).parallel()
                        .mapToObj(BigInteger::valueOf)
                        .reduce(BigInteger::multiply).get();
    }
}
