package Audit_Algorithm;

import java.util.Scanner;

public class E265_convert_decimal_to_octal {
    public static void main(String[] args) {
        System.out.println("input number: ");
        Scanner scanner = new Scanner(System.in);
        convert(Integer.parseInt(scanner.nextLine()));
    }

    private static void convert(int num) {
        int result = 0;
        int decimal = 1;
        while (num != 0){
            result = result + num % 8 * decimal;
            num = num / 8;
            decimal *= 10;
        }
           System.out.println(result);
    }
}
