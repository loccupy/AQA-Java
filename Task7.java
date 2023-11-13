import java.util.Arrays;

public class Task7 {

    public static int [] task7() {
        int [] array = new int [100];
        for(int i = 0;i < array.length;i++){
            array[i] = i + 1;
        }
        return array;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(task7()));

    }
}
