import java.util.Arrays;

public class Task8 {
    
    public static int [] task8 () {
        int [] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < array.length; i ++){
            if(array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(task8()));
    }
}
