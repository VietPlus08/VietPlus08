package ss1;

import java.util.Scanner;

public class conver_number_to_string2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the number: ");
        int number = scanner.nextInt();
        String s = "";
        int position = 1;
        int previousNum = 0;
        if (number == 0) {
            s = "zero";
        } else if (number < 1000) {
            s = changeNumberToText_3Digit(number, previousNum, position);
        } else if (number < 1000000) {
            s = changeNumberToText_3Digit(number / 1000, previousNum, position) + " thousand "
                    + changeNumberToText_3Digit(number % 1000, previousNum, position);
        }else if (number < 1000000000){
            s = changeNumberToText_3Digit(number / 1000000, previousNum, position) + " million "
                    + changeNumberToText_3Digit(number / 1000, previousNum, position) + " thousand "
                    + changeNumberToText_3Digit(number % 1000, previousNum, position);
        }
        System.out.println("Result: " + s);
    }

    public static String changeNumberToText_3Digit(int number, int previousNum, int position) {
        StringBuilder s = new StringBuilder();
        while (number != 0) {
            String text = changeNumbertoText(number % 10, previousNum, position);
            if (number == 100) {
                s = new StringBuilder("one hundred");
            } else if (position == 2 && number % 10 == 1) {
                s = new StringBuilder(new String(text));
            } else {
                if (!text.equals("")) {
                    if (position != 1) s.insert(0," ");
                    s.insert(0, text + positionDecimal(previousNum, position));
                }
            }
            previousNum = number % 10;
            number = number / 10;
            position++;
        }
        return new String(s);
    }

    public static String positionDecimal(int preNum, int position) {
        if (position == 3) return " hundred and";
//        if (position == 4 && preNum == 0) return " thousand and";
//        if (position == 4) return " thousand";
        return "";
    }

    public static String changeNumbertoText(int num, int preNum, int pos) {
        if (pos == 2 && num == 1) {
            switch (preNum) {
                case 0:
                    return "ten";
                case 1:
                    return "eleven";
                case 2:
                    return "twelve";
                case 3:
                    return "thirteen";
                case 4:
                    return "fourteen";
                case 5:
                    return "fifteen";
                case 6:
                    return "sixteen";
                case 7:
                    return "seventeen";
                case 8:
                    return "eighteen";
                case 9:
                    return "ninteen";
                default:
                    return "";
            }
        }
        if (pos == 2) {
            switch (num) {
                case 2:
                    return "twenty";
                case 3:
                    return "thirty";
                case 4:
                    return "fourty";
                case 5:
                    return "fifty";
                case 6:
                    return "sixty";
                case 7:
                    return "seventy";
                case 8:
                    return "eighty";
                case 9:
                    return "ninty";
                default:
                    return "";
            }
        }
        switch (num) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }
}
