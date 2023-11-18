package repoAnimal;

public class Cat extends Animal {

    final int LIMIT_CAT_RUN = 200;
    final int LIMIT_CAT_SWIM = 0;
    static int cat_counting = 0;

    public Cat(String name) {
        super(name);
        cat_counting++;
    }

    public void run(int dist) {
        if(dist <= LIMIT_CAT_RUN) System.out.println("Кот " +
             name + " пробежал " + dist + " м.\n");
        else System.out.println("Кот " + name + 
            " не сможет столько пробежать.\n");
    }
    
    public void swim(int dist) {
        System.out.println("К сожалению " + name +
             " не умеет плавать.\n");
    }

    public void total_cats(){
        System.out.println("Количество созданных кошек = " +
             cat_counting + ".\n");
    }
}
