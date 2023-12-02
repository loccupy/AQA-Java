import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("ac", "ad", "aa", "ab", "az"));
        System.out.println("\nИсходная коллекция: " + list);
        String[] result =  list.stream().sorted().toArray(String[]::new);
        System.out.println("\nМассив после сортировки: " + Arrays.toString(result));
    }
}
