package repoPhoneBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void loadDataFromFileCsv (String fileName, PhoneBook book) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while((line = reader.readLine()) != null) {
                String[] tmp = line.split(";");
                book.add(tmp[0], tmp[1]); 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PhoneBook book = new PhoneBook();
        loadDataFromFileCsv("repoPhoneBook/directory.csv", book);
        book.add("ХРИСТОРОЖДЕСТВЕНСКИЙ", "+973 (658) 908-66-98");
        book.displayDirectory();
        System.out.println("********************");
        book.get("ХРИСТОРОЖДЕСТВЕНСКИЙ");
        book.get("Иванов");
        book.get("Кузнецов");
        book.get("Смирнов");
    }
}
