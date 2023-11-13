public class Task10 {

    public static int [] task10(int len, int initialValue) {
        int [] array = new int [len];
        for(int i = 0; i < array.length; i++){
            array[i] = initialValue;
        }
        return array;
    }
}
