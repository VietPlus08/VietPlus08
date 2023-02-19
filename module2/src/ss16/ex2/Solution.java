package ss16.ex2;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Nation> list = ReadWriteFile.readFromFile(".\\src\\ss16\\student.csv");
        list.forEach(System.out::println);
    }
}
