package ss3;

import java.util.Objects;
import java.util.Scanner;

public class count_frequency_of_element_in_string {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string: ");
        String string = scanner.nextLine();
        System.out.print("Input element of string u want to count: ");
        String item = scanner.nextLine();
        if (item.trim().length() != 1){
            System.out.println("Just one digit!");
            return;
        }
        int count = 0;
        char[] chars = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == item.charAt(0)){
                count++;
            }
        }
        System.out.printf("Frequency of %s: %d",item, count);
    }
}
