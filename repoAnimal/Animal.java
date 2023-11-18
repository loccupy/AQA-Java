package repoAnimal;

public class Animal {

    String name;
    static int all_animal_counting = 0;
    int animal_counting = 0;

    public Animal(String name){
        this.name = name;
        all_animal_counting++;
        animal_counting++;
    }

    public void run(int dist) {
        System.out.println( name + " побежал.\n");
    }

    public void swim(int dist) {
        System.out.println(name + " поплыл.\n");
    }

    public void all_total_animals(){
        System.out.println("Общее количество созданных животных = " + 
            all_animal_counting + ".\n");
    }
    
    public void total_animals(){
        System.out.println("Количество созданных животных без принадлежности к виду = " + 
            animal_counting + ".\n");
    }
}
