package bai_tap_2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayScanner {
    static Scanner scanner = new Scanner(System.in);
//        return "CODE,NAME,ID_PERSON,BALANCE,MAX_MONEY";

    public static List<String> getDataFromConsole(String data) {
        String[] inputData = data.split(",");
        List<String> result = new ArrayList<>();
        for (String s : inputData) {
            if (s.equals("CODE") || s.equals("NAME") || s.equals("ID_PERSON")) {
                result.add(checkValid(s, "\\w+"));
                continue;
            }
            if (s.equals("BALANCE") || s.equals("MAX_MONEY")) {
                result.add(checkValid(s, "[0-9]+"));
            }
        }
        return result;
    }

    private static String checkValid(String s, String regex) {
        boolean flag = true;
        while (true) {
            System.out.printf(flag ? "Input %s: " : "Input %s again: ", s);
            String input = scanner.next().trim();
            if (input.matches(regex)) {
                return input;
            }
            flag = false;
        }
    }
}
