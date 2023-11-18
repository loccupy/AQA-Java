package repoAnimal;

public class Main {
    
    public static void main(String[] args) {
        Animal animal = new Animal("Сосиска");
        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Шарик");
        animal.run(300);
        animal.swim(200);
        cat.run(250);
        cat.run(100);
        cat.swim(10);
        dog.run(300);
        dog.run(600);
        dog.swim(10);
        dog.swim(300);
        animal.all_total_animals();
        animal.total_animals();
        cat.total_cats();
        dog.total_dogs();
    }
    
}
