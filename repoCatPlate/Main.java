package repoCatPlate;

public class Main {
    public static void main(String[] args) {
        
        Plate plate = new Plate(215);
        Cat [] cats = new Cat[3];
        cats [0] = new Cat ("Черныш", 200);
        cats [1] = new Cat ("Белыш", 150);
        cats [2] = new Cat ("Голубыш", 250);
        plate.getFood();
        System.out.println("\n****************Запускаем первый процесс кормления.\n");
        for(Cat tmp: cats) {
            tmp.eatCat(plate);
        }
        plate.getFood();
        System.out.println("\n****************Добавляем еду в тарелку.\n");
        plate.addFood(350);
        plate.getFood();
        System.out.println("\n****************Запускаем второй процесс кормления.\n");
        for(Cat tmp1: cats) {
            tmp1.eatCat(plate);
        }
        plate.getFood();
        System.out.println("\n****************Выводим информацию о сытости котов.\n");
        for(Cat tmp2: cats){
            tmp2.infoAppetitCats();
        }
        System.out.println("\n****************Выводим общую информацию о котах.\n");
        for(Cat tmp3: cats){
            tmp3.getAppetit();
        }
        System.out.println("\n*******************************\n");
    }
    
}
