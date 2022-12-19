package ss1;

import java.util.Scanner;

public class conver_number_to_string2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the number: ");
        int number = scanner.nextInt();
        System.out.println("Result: " + solve(number));
    }

    // bài giải bắt đầu từ đây
    public static String solve(int n) {
        String s = "";
        if (n == 0) {
            s = "zero";
        } else if (n < 1000) {
            s = changeNumberToText_3Digit(n, "");
        } else if (n < 1000000) {
            s = changeNumberToText_3Digit(n / 1000, "thousand") + " "
                    + changeNumberToText_3Digit(n % 1000, "unit");
        } else if (n % 1000000 == 0) {
            s = changeNumberToText_3Digit(n / 1000000, "million");
        } else {
            s = changeNumberToText_3Digit(n / 1000000, "million") + " "
                    + changeNumberToText_3Digit(n / 1000 % 1000, "thousand") + " "
                    + changeNumberToText_3Digit(n % 1000, "unit");
        }
        return new String(s.substring(0,1).toUpperCase() + s.substring(1));
    }

    public static String changeNumberToText_3Digit(int number, String decimals) {
        int position = 1;
        int previousNum = 0;
        StringBuilder s = new StringBuilder();
        while (number != 0) {
            String text = convertToText(number % 10, previousNum, position);
            if (number % 100 == 0) {
                s.insert(0, convertToText(number / 100, previousNum, position) + " hundred");
                number = number / 100;
            } else if (position == 2 && number % 10 == 1) {
                s = new StringBuilder(new String(text));
            } else {
                if (!text.equals("")) {
                    if (position != 1) s.insert(0, " ");
                    if (position == 3) {
                        if (decimals.equals("unit")) s.insert(0, " hundreds and");
                        else if (decimals.equals("")) s.insert(0, " hundred and");
                        else s.insert(0, " hundred");
                    }
                    s.insert(0, text);
                }
            }
            previousNum = number % 10;
            number = number / 10;
            position++;
        }
        if (decimals.equals("unit")) {
            return new String(s);
        } else {
            return new String(s + " " + decimals);
        }
    }

    public static String convertToText(int num, int preNum, int pos) {
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
                    return "forty";
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
