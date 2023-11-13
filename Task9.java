import java.util.Arrays;
import java.util.Scanner;

public class Task9 {

    public static int [] [] task9 () {
        System.out.println("Задайте размер квадратного двумерного целочисленного массива:");
        try (Scanner sc = new Scanner(System.in)) {
            int size = sc.nextInt();
            int [] [] array = new int[size][size];
            int z = array[0].length - 1;
            for(int i = 0; i < array.length; i++,z--){
                array[i][z] = 1;
                for(int x = array[i].length - 1;x >= 0;x--){
                    if(i == x) array[i][x] = 1;
                }
            }
            return array;
        }
    }

    public static void main(String[] args) {
        int [] [] array = task9();
        for (int i = 0; i < array.length; i++) {
    System.out.println(Arrays.toString(array[i]));
        }
    }
}
