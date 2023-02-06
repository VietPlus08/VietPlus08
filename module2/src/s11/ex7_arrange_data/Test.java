package s11.ex7_arrange_data;

import java.time.LocalDate;
import java.util.*;

public class Test {
    private static List<Person> repo = new ArrayList<>();
    private static List<Person> result = new ArrayList<>();

    static {
        repo.add(new Person("A", "Male", LocalDate.parse("2002-12-12")));
        repo.add(new Person("B", "FeMale", LocalDate.parse("2000-12-12")));
        repo.add(new Person("C", "Male", LocalDate.parse("2001-12-12")));
        repo.add(new Person("D", "FeMale", LocalDate.parse("2005-12-12")));
        repo.add(new Person("E", "Male", LocalDate.parse("2007-12-12")));
        repo.add(new Person("F", "FeMale", LocalDate.parse("1995-12-12")));
    }

    public static void main(String[] args) {
        Queue<Person> male = new LinkedList<>();
        Queue<Person> female = new LinkedList<>();
        Collections.sort(repo);
        repo.forEach(i -> {
            if (i.getGender().toLowerCase().equals("male")) {
                male.add(i);
            } else {
                female.add(i);
            }
        });
        result.addAll(female);
        result.addAll(male);
        result.forEach(System.out::println);
    }
}
