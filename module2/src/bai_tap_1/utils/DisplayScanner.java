package bai_tap_1.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayScanner {
    static Scanner scanner = new Scanner(System.in);

    public static List<String> getDataFromConsole(String data) {
//        "ID,CODE,NAME,PRICE,QUANTITY,MANUFACTURE,IMPORT_PRICE,IMPORT_DISTRICT,VAT";
        String[] inputData = data.split(",");
        List<String> result = new ArrayList<>();
        for (String s : inputData) {
            if (s.equals("CODE") || s.equals("NAME") || s.equals("MANUFACTURE") || s.equals("IMPORT_DISTRICT") || s.equals("EXPORT_NATION")) {
                result.add(checkValid(s, "\\w+"));
                continue;
            }
            if (s.equals("ID") || s.contains("PRICE") || s.equals("VAT") || s.equals("QUANTITY")) {
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
