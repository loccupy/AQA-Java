public class Main {

    public static void main(String[] args) {
        System.out.println("\n1. Создадим две пустые коробки test1 и test2" +
                           " вместимостью 100.");
        Box<Fruit> test1 = new Box<>(100);
        Box<Fruit>test2 = new Box<>(100);
        System.out.println("//Коробка test1:");
        test1.getInfoAboutBox();
        System.out.println("//Коробка test2:");
        test2.getInfoAboutBox();

        System.out.println("\n2. Добавим в коробки test1 и test2 яблоки -" +
                            " 80 и 20 штук соответственно:");
        System.out.println("//Добавляем в test1:");
        test1.addBox(new Apple(), 80);
        System.out.println("//Добавляем в test2:");
        test2.addBox(new Apple(), 20);
        System.out.println("//Коробка test1:");
        test1.getInfoAboutBox();
        System.out.println("//Коробка test2:");
        test2.getInfoAboutBox();

        System.out.println("\n3. Пересыплем из коробки test1 в test2:");
        System.out.println("//Коробка test1:");
        test1.getInfoAboutBox();
        System.out.println("//Коробка test2:");
        test2.getInfoAboutBox();
        System.out.println("//Пересыпаем...");
        test1.pourOverBox(test2);
        System.out.println("//Коробка test1:");
        test1.getInfoAboutBox();
        System.out.println("//Коробка test2:");
        test2.getInfoAboutBox();

        System.out.println("\n4. Создадим коробку test3 c апельсинами:");
        System.out.println("//Создаем...");
        Box<Fruit> test3 = new Box<>(100);
        System.out.println("//Кладем в коробку 30 апельсинов...");
        test3.addBox(new Orange(), 30);
        System.out.println("//Коробка test3:");
        test3.getInfoAboutBox();

        System.out.println("\n5. Сравним вес коробок test2 c яблоками" +
                           " и test3 с апельсинами:");
        System.out.println("//Если равны - true:");
        if(test3.compare(test2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("\n6. Попробуем пересыпать из test2 в test3:");
        System.out.println("//Пересыпаем:");
        test2.pourOverBox(test3);
        System.out.println("//Коробка test2:");
        test2.getInfoAboutBox();
        System.out.println("//Коробка test3:");
        test3.getInfoAboutBox();

        System.out.println("\n7. Создадим коробку test4 наполненную апельсинами " +
                            "и сразу пересыплем максимум из test4 в test3:");
        Box<Fruit> test4 = new Box<>(new Orange(), 120);
        System.out.println("//Коробка test4:");
        test4.getInfoAboutBox();
        System.out.println("//Пересыпаем...");
        test4.pourOverBox(test3);
        System.out.println("//Коробка test3:");
        test3.getInfoAboutBox();
        System.out.println("//Коробка test4:");
        test4.getInfoAboutBox();

        System.out.println("\n8. Пробуем добавить в полную коробку фрукты:");
        System.out.println("//Коробка test3:");
        test3.getInfoAboutBox();
        System.out.println("//Добавляем:");
        test3.addBox(new Orange(), 1);

        System.out.println("\n9. Пробуем добавить в коробку с апельсинами яблоко:");
        System.out.println("//Добавляем:");
        test3.addBox(new Apple(), 1);

        System.out.println("\n10. Выведем вес коробки через метод getWeight");
        System.out.println("//Вес коробки test3 равен:");
        System.out.println(test3.getWeight());
        System.out.println("//Коробка test3:");
        test3.getInfoAboutBox();

        System.out.println("\n11. Создадим коробку с апельсинами test5" +
                           " с помощью конструктора с автоматическим заполнением" +
                           " и сравним с коробкой test3:");
        Box<Fruit> test5 = new Box<>(new Orange(), 100);
        System.out.println("//Коробка test5:");
        test5.getInfoAboutBox();
        System.out.println("//Коробка test3:");
        test3.getInfoAboutBox();
        System.out.println("//Если равны - true:");
        if(test5.compare(test3)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("\n12. Cоздаем две полностью заполненные коробки" +
                            " test6 и test7 c одинаковой вместимостью " +
                            "и весом, ");
        System.out.println("но разными видами фруктов"  +
                            ", и сравниваем через метод compare:");
        System.out.println("//Cоздаем...:");
        Box<Orange> test6 = new Box<>(new Orange(), 120);
        Box<Apple> test7 = new Box<>(new Apple(), 120);
        System.out.println("//Коробка test6:");
        test6.getInfoAboutBox();
        System.out.println("//Коробка test7:");
        test7.getInfoAboutBox();
        System.out.println("//Если равны - true:");
        if(test6.compare(test7)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("\n//...");
    }
}
