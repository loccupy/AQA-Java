package repoException;

import java.util.Arrays;
import java.util.Scanner;

public class ExceptionTraine {

    public static String[][] createAnArray(){
            
        int lines = 0;
        int columns = 0;
        try (Scanner num = new Scanner(System.in)) {
            System.out.println("Создадим двумерный прямоугольный массив!!!\n");
            System.out.println("Введите количество строк массива:");
            if (num.hasNextInt()) {
                lines = num.nextInt();
            } else {
                System.out.println("Это не int! Попробуйте снова.");
                System.exit(1);
            }
            System.out.println("Введите количество столбцов массива:");
            if (num.hasNextInt()) {
                columns = num.nextInt();
            } else {
                System.out.println("Это не int! Попробуйте снова.");
                System.exit(1);
            }
            String[][] strArray= new String[lines][columns];
            System.out.println("Заполняем массив построчно:");
            try (Scanner forStr = new Scanner(System.in)) {
                for (int i = 0;i < strArray.length;i++) {
                    for (int z = 0;z < strArray[i].length;z++){
                        if (forStr.hasNextLine()) {
                            strArray[i][z] = forStr.nextLine();
                        } else {
                            System.out.println("Это не строка!");
                            System.exit(1);
                        }
                    }
                }
            }
            System.out.println("Получился массив такого вида:" + Arrays.deepToString(strArray));
            return strArray;
        }
    }

    public static boolean checkStringForInt(String number) {

        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '-') continue;
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length == 4){
            for (int i = 0;i < array.length;i++){
                if (array.length != array[i].length) {
                    throw new MyArraySizeException("Неверное количество столбцов!");
                }
            }
        } else {
            throw new MyArraySizeException("Неверное количество строк!");
        }
        int res = 0;
        for (int i = 0;i < array.length;i++) {
            for (int z = 0; z < array[i].length;z++) {
                if (!checkStringForInt(array[i][z])) {
                    throw new MyArrayDataException(String.format("Неправильный тип данных в ячейке [%d][%d]!", i, z));
                }
                res += Integer.parseInt(array[i][z]);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String[][] array = null;
        int i = 2;
        System.out.print("Как пожелаете получить массив:\n" + 
            " Нажмите 1 - если хотите сами сконструировать;\n" + 
            " Нажмите 2 - если подходит прописанный вариант:  ");
        try (Scanner chois = new Scanner(System.in)) {
            if (chois.hasNextInt()) {
                i = chois.nextInt();
            } else {
                System.out.println("Вы ввели другой символ." + 
                "Попробуйте снова.");
                return;
            }
            if (i == 1) {
                array = createAnArray();
            } else if (i == 2) {
                array = new String[][] {
                {"1", "1", "1", "-1"},
                {"1", "1", "1", "-1"},
                {"1", "1", "1", "-1"},
                {"1", "1", "1", "-1"}
                };
                System.out.println("Вы выбрали прописанный вариант.\nОн выглядит так: " +
                Arrays.deepToString(array) + 
                "\nВы можете менять его значения в матрице в методе main.");
                
            } else {
                System.out.println("Вы ввели другое число." + 
                "Попробуйте снова.");
                return;
            }
        }

        try {
            System.out.println("Сумма всех элементов этого массива: " + checkArray(array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Была введена пустая строка.\nПопробуйте еще раз.");
        }
    }
}
