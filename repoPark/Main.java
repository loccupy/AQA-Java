package repoPark;

class Main {
    public static void main(String[] args) {
        Park a = new Park();

        a.setAttractioninPark("Американские гонки", "с 10 до 17", 225);
        a.setAttractioninPark("Белорусские горки", "с 11 до 16", 125);
        a.setAttractioninPark("Радостные пони", "с 8 до 16", 300);
        a.setAttractioninPark("Чашки", "с 10 до 17", 150);
        a.setAttractioninPark("Мертвая петля", "с 11 до 16", 3500);
        a.setAttractioninPark("Сапоги скороходы", "с 8 до 16", 240);
        a.getPark();
        a.getPark(6);

    }
}