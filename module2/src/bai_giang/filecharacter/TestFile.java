package bai_giang.filecharacter;

import java.util.ArrayList;
import java.util.List;

public class TestFile {
    public static void main(String[] args) {
        FileUtils utils = new FileUtils();
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Hoang Nam", 7f));
        students.add(new Student(2, "Khanh Huyen", 8.5f));
        students.add(new Student(3, "Van Hoai", 7.5f));
        students.add(new Student(4, "Khanh Van", 9.5f));
        students.add(new Student(5, "Hoai Son", 6.5f));

//        utils.writeToFile3(".\\src\\filecharacter\\student.csv", students);
//        List<Student> sts = utils.readFromFile(".\\\\src\\\\filecharacter\\\\student.csv");
//        sts.forEach(System.out::println);
//        System.out.println(sts.get(5).mark);
        ReadWriteFile.writeToFile(".\\src\\filecharacter\\student1.csv", students);
        List<Student> students1 = ReadWriteFile.readFromFile(".\\src\\filecharacter\\student1.csv");
        students1.forEach(System.out::println);
    }
}
