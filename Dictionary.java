import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dictionary {

    public static void main(String[] args) {

        String[] word = {
            "one", "two", "tree", "four",
            "five", "six", "seven", "eight",
            "nine", "ten", "one", "two", "tree",
            "one", "two", "five"};

        System.out.println("Начальный массив: [");
        for(String tmp: word) {
            System.out.println("      " + tmp);
        }
        System.out.println("                  ]");

        System.out.println("     **********");
        ArrayList <String> wordList = new ArrayList<>();

        for(String tmp: word) {
            if(!wordList.contains(tmp)) {
                wordList.add(tmp);
            }
        }

        ArrayList <String> count = new ArrayList<>(Arrays.asList(word));
        
        for(String tmp: wordList) {
            System.out.println("Слово " + tmp + 
            " встречается " + Collections.frequency(count, tmp) +
             " раз.");
        }

        System.out.println("\n     **********");
        System.out.println("Список уникальных слов: " + wordList.toString() + "\n");
    }
}
