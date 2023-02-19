package ss16.ex1;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = ReadWriteFile.readFromFile(".\\src\\ss16\\student.csv");
        list.forEach(System.out::println);
        ReadWriteFile.writeToFile(".\\src\\ss16\\file_student_copy.csv",list);
    }
}
