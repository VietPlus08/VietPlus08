package s11.ex7_arrange_data;

import java.time.LocalDate;
import java.util.Date;

public class Person implements Comparable<Person>{
    private String name, gender;
    private LocalDate bod;

    public Person(String name, String gender, LocalDate bod) {
        this.name = name;
        this.gender = gender;
        this.bod = bod;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBod() {
        return bod;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", bod=" + bod +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.bod.compareTo(o.bod);
    }
}
