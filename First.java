import java.util.Scanner;

public class First{
    public static boolean first(int a, int b) {
        if(a + b >= 10 && a + b <= 20) return true;
        else return false;
    }
    public static void main(String[] args) {
        try (Scanner a1 = new Scanner(System.in)) {
            try (Scanner a2 = new Scanner(System.in)) {
                int a = a1.nextInt();
                int b = a2.nextInt();
                if(first(a, b)) System.out.println("true");
                else System.out.println("False");
            }
        }
        
    }
    
}
