import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList <String> listOfLogins = new ArrayList<>();
        enterLogin(listOfLogins);
        System.out.println("Список логинов, начинающихся с 'f':");
        listOfLogins.stream()
                    .filter(x -> x.charAt(0) == 'f')
                    .forEach(x -> System.out.println("     " + x));
    }

    public static void enterLogin(ArrayList <String> listOfLogins) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин: ");
        while(true) {
            String tmp = sc.nextLine();
            if(tmp.isEmpty()){
                break;
            } else {
                listOfLogins.add(tmp);
            }
        }
    }
}
