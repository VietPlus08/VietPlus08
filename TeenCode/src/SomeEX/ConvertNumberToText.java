package SomeEX;

import java.util.Scanner;

public class ConvertNumberToText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number: ");
        int number = scanner.nextInt();
        String s = "";
        int pos = 1;
        int lastNum = 0;
        while (number%10 != 0){
            if (pos == 2 && number%10 == 1){
                s = changeNumberChar(number%10, lastNum, pos);
            } else {
                s = changeNumberChar(number%10, lastNum, pos) + positionDecimal(pos) + " " + s;
            }
            lastNum = number%10;
            number = number/10;
            pos ++;
        }
        System.out.println(s);

    }
    public static String positionDecimal(int position){
        if (position == 3) return " hundred";
        if (position == 4) return " thousand";
        return "";
    }

    public static String changeNumberChar(int num, int lastN, int pos){
        if (pos == 2 && num == 1){
            switch (lastN){
                case 1: return "eleven";
                case 2: return "twelve";
                case 3: return "thirteen";
                case 4: return "fourteen";
                case 5: return "fifteen";
                case 6: return "sixteen";
                case 7: return "seventeen";
                case 8: return "eighteen";
                case 9: return "ninteen";
                default: return "";
            }
        }
        if (pos == 2){
            switch (num){
                case 1: return "one";
                case 2: return "twenty";
                case 3: return "thirty";
                case 4: return "fourty";
                case 5: return "fifty";
                case 6: return "sixty";
                case 7: return "seventy";
                case 8: return "eighty";
                case 9: return "ninty";
                default: return "";
            }
        }
        switch (num){
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }
}
