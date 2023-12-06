import java.util.ArrayList;


public class Box<T extends Fruit> {

    private final ArrayList<T> obj;
    private String init = "пустая";
    private final double limitBox;

    public Box(double limitBox) {
        this.obj = new ArrayList<>();
        this.limitBox = limitBox;
    }

    public Box(T obj, double limitBox) {
        if (obj == null) {
            System.out.println("Ошибка данных при " +
                    "использовании конструктора!");
            System.exit(1);
        }
        this.obj = new ArrayList<>();
        this.init = obj.getInit();
        this.limitBox = limitBox;
        int quantity;
        quantity = (int) (this.limitBox/obj.weight);
        for (int i = 0; i < quantity; i++) {
            this.obj.add(obj);
        }
    }

    public void addBox(T unknownBox, int quantity) {
        if ((this.getWeight() + unknownBox.weight) <= this.limitBox) {
            if (this.init.equals("пустая")) {
                this.init = unknownBox.getInit();
                for(int i = 0; i < quantity; i++){
                    this.obj.add(unknownBox);
                }
                System.out.println("Добавили в коробку " +
                                    quantity + " фруктов.");
            } else if (this.init.equals(unknownBox.getInit())) {
                for(int i = 0; i < quantity; i++){
                    this.obj.add(unknownBox);
                }
                System.out.println("Добавили в коробку " +
                        quantity + " фруктов.");
            } else {
                System.out.println("Эта коробка для других фруктов!" +
                        " Попробуйте снова.");
            }
        } else {
            System.out.println("В ящике не хватит места!" +
                    " Сейчас ящик вмещает " + this.limitBox);
        }
    }

    public double getWeight() {
        double weight;
        if (this.obj.isEmpty()) {
            return 0;
        }
        weight = this.obj.size()*this.obj.get(0).getWeight();
        return weight;
    }

    public boolean compare(Box<?> unknownBox) {
        if (unknownBox == null && this.obj == null) {
            return true;
        } else if (unknownBox == null) {
            return false;
        }
        return this.getWeight() == unknownBox.getWeight();
    }

    public void pourOverBox(Box <T> unknownBox) {
        if (this == unknownBox) {
            System.out.println("Нельзя пересыпать из этой же коробки.");
            return;
        }
        if (!this.init.equals("пустая")) {
            if (!this.init.equals(unknownBox.init) &&
                !unknownBox.init.equals("пустая")) {
                System.out.println("Разные виды фруктов!" +
                        "Нельзя пересыпать.");
            } else if (unknownBox.limitBox - unknownBox.getWeight() >=
                       this.getWeight()) {
                unknownBox.obj.addAll(this.obj);
                unknownBox.init = this.obj.get(0).init;
                this.obj.clear();
                this.init = "пустая";
                System.out.println("Пересыпали полностью!\n");
            } else if (unknownBox.limitBox - unknownBox.getWeight() <
                        this.getWeight()) {
                double differenceInWeight = unknownBox.limitBox -
                       unknownBox.getWeight();
                int quantity = (int) (differenceInWeight/this.obj.get(0).weight);
                for (int i = 0; i < quantity; i++) {
                    unknownBox.obj.add(this.obj.get(0));
                    this.obj.remove(0);
                }
                System.out.println("Пересыпали " + quantity + " фруктов.\n" +
                                   "-----------------");
            }
        } else {
                System.out.println("Нечего пересыпать!!\n");
        }
    }

    public void getInfoAboutBox() {
        if (init.equals("пустая")) {
            System.out.println("Эта пустая коробка!");
        } else {
            System.out.println("В этой коробке лежат " +
                                this.init + "\nВес нетто: " +
                                this.getWeight() +
                                "\nКоличество фруктов в штуках: " +
                                (int)(this.getWeight()/this.obj.get(0).weight));
        }
        System.out.println("Максимальная вместительность коробки по весу: " +
                            this.limitBox);
        System.out.println("-----------------");
    }
}
