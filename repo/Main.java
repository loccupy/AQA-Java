package repo;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AppData obj = new AppData();
      //  AppData obj2 = new AppData(new String[] {"Value 1", "Value 2", "Value 3"}, new int[][]{{100,200,123}, {300,400,500}});
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
