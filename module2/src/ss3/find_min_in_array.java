package ss3;

import java.util.Scanner;

public class find_min_in_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of element: ");
        int index = scanner.nextInt();
        int[] arr = new int[index];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < index; i++) {
            System.out.print("Input arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
            min = Math.min(min, arr[i]);
        }
        System.out.println("Min = " + min);
    }
}
