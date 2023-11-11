import java.util.Arrays;

public class Tenth {
    public static int [] tenth(int len, int initialValue) {
        int [] array = new int [len];
        for(int i = 0; i < array.length; i++){
            array[i] = initialValue;
        }
        return array;
    }
    public static void main(String[] args) {
        int a =10;
        int b = 0;
        System.out.println(Arrays.toString(tenth(a, b)));
    }
}