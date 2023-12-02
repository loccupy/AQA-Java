import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static int getRandomNumber() {

        return (int) (Math.random()*500);
    }

    public static void main(String[] args) {
        List <Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(getRandomNumber());
        }
        System.out.println(list) ;
        Stream<Integer> stream = list.stream();
        System.out.println(stream.filter(z-> z%2 == 0).count());
    }
}
