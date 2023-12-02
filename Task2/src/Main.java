import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("Highload", "High", "Load", "Highload"));
        System.out.println("\nИсходная коллекция:\n" + list + "\n");
        try {
            System.out.println("Cколько раз объект «High» встречается в коллекции:\n   " +
                    countHigh(list));
            System.out.println("\nКакой элемент в коллекции находится на первом месте:\n   " +
                    firstElement(list));
            System.out.println("\nКакой элемент в коллекции находится на последнем месте:\n   " +
                    lastElement(list));
        } catch (Exception e) {
            System.out.println("Нельзя вызывать эти методы с нулевым параметром!!!");
        }
    }

    public static Object countHigh(List<String> list) {
        if(!list.isEmpty()){
            return list.stream().filter(x -> x.equals("High")).count();
        }
            return 0;
    }

    public static Object firstElement(List<String> list) {
            return list.stream().findFirst().orElse(String.valueOf(0));
    }

    public static Object lastElement(List<String> list) {
        return list.stream().reduce((a1,a2) -> a2).orElse(String.valueOf(0));
    }
}
