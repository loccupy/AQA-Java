import java.util.Arrays;
import java.util.Scanner;

public class Task6 {

    public static int [] task6() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите длину массива: ");
            int length = scanner.nextInt();
            int[] array = new int[length];
            System.out.println("Введите элементы массива - 0 или 1:");
            for (int i = 0; i < length; i++){
                int tmp = scanner.nextInt();
                if(tmp == 1 || tmp == 0) {
                    array[i] = tmp;
                } else {
                    System.out.println("Введите 0 или 1 !!!");
                    i--;
                }
            }  
            System.out.println("Массив исходный:\n" + Arrays.toString(array)+ "\n");
            for(int i = 0;i < array.length; i++){
                if(array[i] == 1) {
                    array[i]=0;
                } else {
                    array[i] = 1;
                }
            }
            return array;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Массив после замены 0 на 1, 1 на 0:\n" + Arrays.toString(task6()));
    }
}
