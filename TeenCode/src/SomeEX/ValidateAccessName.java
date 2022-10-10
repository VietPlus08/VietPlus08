package SomeEX;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccessName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ho ten: ");
        ValidateAccName(scanner.nextLine());
    }
    public static void ValidateAccName(String s){
        StringBuilder sb = new StringBuilder();
//        s = s.trim();
//        List<String> list = Arrays.asList(s.split("(\s)+"));
//        for (String str: list){
//            sb.append(" " + str.trim());
//        }
//        sb.deleteCharAt(0);

        Pattern pattern = Pattern.compile("(\\w+)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            if (sb.isEmpty()){
                sb.append(upperFirstLetter(s.substring(matcher.start(), matcher.end())));
                continue;
            }
            sb.append(" " + upperFirstLetter(s.substring(matcher.start(), matcher.end())));
        }
        System.out.println(sb);
    }
    public static String upperFirstLetter(String s){
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
}
