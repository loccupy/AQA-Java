package repo;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AppData obj = new AppData();
        try {
            obj.readFileCsv();
            for(String temp: obj.getHeader()){
                System.out.print(temp + " ");
            }
            System.out.println("\n");
            System.out.println(Arrays.deepToString(obj.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            obj.writeFile1Csv();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
