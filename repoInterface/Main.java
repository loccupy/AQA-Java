package repoInterface;

public class Main {
    
    public static void main(String[] args) {

        Interface [] inter = new Interface[3];
        inter[0] = new Triangle(2, 3, 4, "black", "white");
        inter[1] = new Circle(12, "red", "blue");
        inter[2] = new Rectangle(10, 5, "green", "yellow");

        for(Interface tmp: inter){
            System.out.println("Геометрическая фигура: " + tmp.getClass().getSimpleName() +
                "\nРазмеры: " + tmp.getSize() +
                "\nПериметр: " + tmp.perimeter() +
                "\nПлощадь: " + tmp.area() + 
                "\nЦвет фона: " + tmp.getFillCol() + 
                "\nЦвет границ: " + tmp.getOutCol());
                System.out.println("****************************************");
        }
        System.out.println("Рассчет площади прямоугольника через дефолтный метод интерфейса:\n" + 
            "Площадь геометрической фигуры "+ inter[2].getClass().getSimpleName() +
             ": " + inter[2].perimeter(10, 10));
    }
}
