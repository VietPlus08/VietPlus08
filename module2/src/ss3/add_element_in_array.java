package ss3;

import java.util.Arrays;
import java.util.Scanner;

public class add_element_in_array {
    public static void main(String[] args) {
        int[] arrayInt = {4, 6, 8, 1, 2, 3, 0, 0, 0, 0};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(Arrays.toString(arrayInt));
            System.out.print("Input number u want to add: ");
            int number = scanner.nextInt();
            System.out.print("Input index u want to add: ");
            int index = scanner.nextInt();
            if (index < 0 || index >= 10) {
                System.out.println("Index must be from 0 to 9");
                break;
            }
            boolean flag = false;
            int temp = 0;
            for (int i = 0; i < arrayInt.length; i++) {
                if (i == index) {
                    flag = true;
                    temp = arrayInt[i];
                    arrayInt[i] = number;
                    continue;
                }
                if (flag) {
                    int flagTemp = arrayInt[i];
                    arrayInt[i] = temp;
                    temp = flagTemp;
                }
            }
        }
    }
}
