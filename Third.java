import java.util.Scanner;

public class Third {
    public static boolean third(int number) {
        if(number >= 0) return false;
        else return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(third(a)) System.out.println("отрицательное");
        else System.out.println("положительное");
    }
}