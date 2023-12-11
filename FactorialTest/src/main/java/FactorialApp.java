import java.util.Scanner;

public class FactorialApp {

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число, факториал которого хотите вычислить:");
        if (sc.hasNextInt()) {
            int temp = sc.nextInt();
            if(temp >= 0) {
                System.out.println(temp + "! = " + fact.result(temp));
            } else {
                fact.result(temp);
            }
        } else {
            System.out.println("Это не число. Перезапустите программу и попробуйте снова!");
        }
    }
}
