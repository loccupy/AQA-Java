import java.util.Scanner;

public class Second{
    public static void second(int number) {
        if(number >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрицательное");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        second(a);

    }
}