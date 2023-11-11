import java.util.Arrays;

public class Seventh {
    public static int [] seventh() {
        int [] array = new int [100];
        for(int i = 0;i < array.length;i++){
            array[i] = i + 1;
        }
        return array;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(seventh()));

    }
}
