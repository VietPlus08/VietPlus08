package bai_giang.filebinary;

import java.util.ArrayList;
import java.util.List;

public class FileBinaryTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Hoang Nam", 7f));
        students.add(new Student(2, "Khanh Huyen", 8.5f));
        students.add(new Student(3, "Van Hoai", 7.5f));
        students.add(new Student(4, "Khanh Van", 9.5f));
        students.add(new Student(5, "Hoai Son", 6.5f));
        String path = ".\\src\\filebinary\\student2.dat";
//        FileObjectUtils.writeObject(".\\src\\filebinary\\student2.dat", students);
        FileObjectUtils.readFileObject(path).forEach(System.out::println);
    }
}
