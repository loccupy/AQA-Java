package repoPark;
import java.util.ArrayList;

public class Park {
    private ArrayList <Object> attractions = new ArrayList<Object>();

    public static class Attraction {
        private String name;
        private String time;
        private int cost;

        public Attraction(String name, String time, int cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }

        public String getName(){
            return name;
        }

        public void displayAttraction() {
            System.out.print ( "Аттракцион \"" + name + "\" принимает посетителей " + time
                 + " ч.\nЦена билета "  + cost + " у.е." + "\n");
        }
    }

    public void setAttractioninPark(String name, String time, int cost) // Добавляет аттракцион со всеми данными.
    {
        Attraction tmp = new Attraction(name, time, cost);
        attractions.add(tmp);
    }

    public void getPark() {                                               // С помощью этого метода можно вывести 
        int i = 0;                                                        // названия всех аттракционов.
        System.out.println("***Cписок аттракционов:");
        while (i <=  this.attractions.size() - 1) {
            System.out.print("         № " + (i+1) + " :  ");
            Attraction tmp;
            tmp = (Attraction) this.attractions.get(i);
            System.out.println(tmp.getName());
            i++;
        }
    }

    public void getPark(int i) {                                          // С помощью этого метода можно вывести                                
        System.out.print("\n" + "***Вы выбрали № " + i + ": \n");        // подробную информацию о выбранном 
        Attraction tmp;                                                   // по номеру из предыдущего запроса аттракционе. 
        tmp = (Attraction) this.attractions.get(i - 1);
        tmp.displayAttraction();
    }
}
