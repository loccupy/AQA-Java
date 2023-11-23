package repo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AppData obj = new AppData();
        String[] replaceHeader = new String[]{"First", "Second", "Third"};
        int[][] replaceData = new int[][] {{11, 33, 55},{22, 44, 66}};
        AppData obj1 = new AppData(new String[]{"Test 1", "Test 2", "Test 3"}, new int[][]{{111, 333, 555},{222, 444,666}});
        
        try {
            System.out.println("\n***Тестируем первый конструктор:***\n");
            File filename = new File("repo/file.csv");
            obj.readFileCsv(filename);
            System.out.print("Проверяем содержимое header: ");
            System.out.println(Arrays.toString(obj.getHeader()));
            System.out.print("Проверяем содержимое data: ");
            System.out.println(Arrays.deepToString(obj.getData()));
            System.out.println("Меняем данные.");
            obj.setHeader(replaceHeader);
            obj.setData(replaceData);
            System.out.print("Проверяем содержимое header: ");
            System.out.println(Arrays.toString(obj.getHeader()));
            System.out.print("Проверяем содержимое data: ");
            System.out.println(Arrays.deepToString(obj.getData()));
            obj.writeFile1Csv(filename);
            System.out.println("*******************************************\n");
            System.out.println("***Тестируем второй конструктор:***\n");
            File filenameTest = new File("repo/newFile.csv");
            System.out.print("Проверяем содержимое header: ");
            System.out.println(Arrays.toString(obj1.getHeader()));
            System.out.print("Проверяем содержимое data: ");
            System.out.println(Arrays.deepToString(obj1.getData()));
            obj1.writeFile1Csv(filenameTest);
            System.out.println("*******************************************\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
