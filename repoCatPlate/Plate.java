package repoCatPlate;

public class Plate {

    int food;

    public Plate (int food) {
        this.food = food;
    }

    public void getFood () {
        System.out.println("\n***Сейчас в тарелке " + food + "!***");
    }

    void empyPlate (int appetit) {
        food -= appetit;
    }

    public void addFood(int giveFood) {
        food += giveFood;
        System.out.println("***Добавили еды +" + giveFood + "!***");
    }
}
