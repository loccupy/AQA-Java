import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class Task4 {

    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 28, Gender.MAN)
        );

        System.out.println("\nЭтим студентам грозит получение повестки в этом году:");
        students.stream().filter(x -> x.gender.equals(Gender.MAN))
                .filter(x -> x.age >= 18 && x.age <= 27).forEach(System.out::println);


        double res = students.stream()
                             .filter(x -> x.gender.equals(Gender.MAN))
                             .map(num -> Double.parseDouble(String.valueOf(num.age())))
                             .reduce(0.0, Double::sum);
        res /= students.stream().filter(x -> x.gender.equals(Gender.MAN)).count();
        System.out.printf("\nСредний возраст студентов мужского пола: %.4s лет.\n", res);
    }

    private enum Gender {
        MAN,
        WOMAN
    }

    private static final class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        private Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String name() {
            return name;
        }

        public Integer age() {
            return age;
        }

        public Gender gender() {
            return gender;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}
