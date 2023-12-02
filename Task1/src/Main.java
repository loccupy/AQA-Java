import java.util.ArrayList;

public class Main {

    public static int getRandomNumber() {
        return (int) (Math.random()*500);
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(getRandomNumber());
        }
        System.out.println("\nИсходная коллекция:\n   " + list) ;
        System.out.println("\nКоличество четных элементов:\n   " +
                            list.stream().filter(z-> z%2 == 0).count());
    }
}
