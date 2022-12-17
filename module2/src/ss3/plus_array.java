package ss3;

import java.util.Arrays;
import java.util.Scanner;

public class plus_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input length of array 1: ");
        int length1 = scanner.nextInt();
        int[] arr1 = new int[length1];
        while (length1-- > 0) {
            System.out.print("Input array[" + length1 + "]: ");
            arr1[length1] = scanner.nextInt();
        }
        System.out.print("Input length of array 2: ");
        int length2 = scanner.nextInt();
        int[] arr2 = new int[length2];
        while (length2-- > 0) {
            System.out.print("Input array[" + length2 + "]: ");
            arr2[length2] = scanner.nextInt();
        }
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            if (i < arr1.length) {
                arr3[i] = arr1[i];
                continue;
            }
            arr3[i] = arr2[i - arr1.length];
        }
        System.out.println("Result" + Arrays.toString(arr3));
    }
}
