import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("f10", "f15", "f2", "f4", "f4"));
        System.out.println("\nИсходная коллекция: " + list);
        String[] result =  list.stream().sorted().toArray(String[]::new);
        System.out.println("\nМассив после сортировки: " + Arrays.toString(result));
    }
}
