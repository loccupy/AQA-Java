public class Main{

    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    public static void printColor(){
        int value = 101;
        if(value <= 0){
            System.out.println("Красный");
        }else if(value > 0 && value <= 100){
            System.out.println("Желтый");
        }else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 1, b = 2;
        if(a >= b){
         System.out.println("a >= b");
        }else {
          System.out.println("a < b");
        }
    }

    public static void checkSumSing() {
        int a = 9, b = -10;
        if(a + b >= 0){
            System.out.println("Сумма положительная");
        }else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void main(String[] args) {
        
        System.out.println("\n");
        printThreeWords();
        System.out.println("\n");
        checkSumSing();
        System.out.println("\n");
        printColor();
        System.out.println("\n");
        compareNumbers();
        System.out.println("\n");
     }
}
