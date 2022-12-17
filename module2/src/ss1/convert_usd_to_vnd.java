package ss1;

import java.io.IOException;
import java.util.Scanner;

public class convert_usd_to_vnd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input the money (USD): ");
            int number = scanner.nextInt();
            System.out.printf("After convert to VND: %d VND \n", number * 23000);
        }
    }
}
