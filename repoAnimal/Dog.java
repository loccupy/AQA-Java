package repoAnimal;

public class Dog extends Animal {

    final int LIMIT_DOG_RUN = 500;
    final int LIMIT_DOG_SWIM = 10;
    static int dog_counting = 0;

    public Dog(String name) {
        super(name);
        dog_counting++;
    }

    public void run(int dist) {
        if(dist <= LIMIT_DOG_RUN) System.out.println("Пес " + name +
             " пробежал " + dist + " м.\n");
        else System.out.println("Пес " + name + 
             " не сможет столько пробежать.\n");
    }
    
    public void swim(int dist) {
        if(dist <= LIMIT_DOG_SWIM)System.out.println("Пес " + name + 
             " проплыл " + dist + " м.\n");
        else System.out.println("Пес " + name + 
             " не сможет столько пробежать.\n");
    }
    
    public void total_dogs() {
        System.out.println("Количество созданных собак = " +
             dog_counting + ".\n");
    }
}
