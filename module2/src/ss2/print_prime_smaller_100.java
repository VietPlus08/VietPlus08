package ss2;

import java.util.Scanner;

public class print_prime_smaller_100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i++ < 100) {
            if (isPrime(i)) {
                System.out.print(i + "  ");
            }
        }
    }

    private static boolean isPrime(int i) {
        if (i < 2) {
            return false;
        }
        int count = 0;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
