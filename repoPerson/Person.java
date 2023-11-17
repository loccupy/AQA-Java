package repoPerson;

public class Person{
    String name;
    String profession;
    String phone;
    String email;
    int salary;
    int age;

    public Person(String name, String profession, String phone, String email, int salary, int age){
        this.name = name;
        this.profession = profession;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }
    public void displayPerson() {
        System.out.println("Полное имя: " + name + ".\n    *Подробная информация:* \nПрофессия: " + profession + ";\nНомер телефона: "
             + phone + ";\nЭлектронная почта: " + email + ";\nЗарплата: " + salary + " у.е.;\nПолных лет: " + age + ".");
    }
}
