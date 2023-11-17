package repoPerson;

public class Main {
    public static void main(String[] args) {
        
        repoPerson.Person[] persArray = new repoPerson.Person[5];
        persArray [0] = new Person("Ivanov Ivan", "Engineer", 
            "892312312", "ivivan.gay", 30000, 30);
        persArray [1] = new Person("Petrov Petr", "animator", 
            "03", "ambulance.end", 25000, 25);
        persArray [2] = new Person("Sidorov Sidr","snow blower", 
            "112", "grandfather.com", 35000, 36);
        persArray [3] = new Person("Ivanova Aglaia", "accountant", 
            "123456789", "missUniverse.bu", 20000, 31);
        persArray [4] = new Person("Vladimir Vladimirov", "topManager", 
            "89876543210", "main.ru", 40000, 41);
        for(repoPerson.Person tmp: persArray){
            if(tmp.age > 40){
                tmp.displayPerson();
            }
        }
    }
}
