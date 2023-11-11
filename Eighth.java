import java.util.Arrays;

public class Eighth {
    public static int [] eighth () {
        int [] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < array.length; i ++){
            if(array[i] < 6) array[i] *= 2;
        }
        return array;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(eighth()));
    }
}
