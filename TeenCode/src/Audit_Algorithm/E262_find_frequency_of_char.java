package Audit_Algorithm;

import java.util.Scanner;

public class E262_find_frequency_of_char {
    public static void main(String[] args) {
        System.out.println("Input string: ");
        Scanner scanner = new Scanner(System.in);
        findFrequencyOfChar(scanner.nextLine());
    }
    public static void findFrequencyOfChar(String s){
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)] ++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0)
                System.out.println("Frequency of " + (char)i + ":" + count[i]);
        }
    }

}
