package repoCatPlate;

public class Cat {

    String name;
    int appetit;
    boolean satiety;


    public Cat(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
    }

    public void getAppetit(){
        if(satiety){
            System.out.println("Кот по имени " + name +
                 " имеет вот такой аппетит *" + appetit + 
                "*, и сейчас он сыт!");
        } else {
            System.out.println("Кот по имени " + name +
                 " имеет вот такой аппетит *" + appetit + 
                 "*, и сейчас он голоден!");
        }
    }

    public void eatCat (Plate a) {
        if (satiety) {
            System.out.println("Кот сыт.");
        } else {
            if(a.food < appetit) {
                System.out.println("Коту " + name + 
                    " не хватит еды. Он не будет кушать.");
            } else {
                a.empyPlate(appetit);
                System.out.println("Кот " + name +
                     " покушал."); 
                satiety = true;
            }
        }
    }

    public void infoAppetitCats () {
        if(satiety) System.out.println("Кот по имени " +
             name + " сыт!");
        else System.out.println("Кот по имени " + name +
         " голоден!");
    }
}
