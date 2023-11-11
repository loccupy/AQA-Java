import java.util.Scanner;

public class Fifth {
    public static boolean fifth(int number) {
        if(number%4 == 0 && number%100 != 0 || number%400 == 0) return true;
        else return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        if(fifth(a) == true) System.out.println("Высокосный");
        else System.out.println("Не высокосный");    
}
}