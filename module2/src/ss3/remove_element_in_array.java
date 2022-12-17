package ss3;

import java.util.Arrays;
import java.util.Scanner;

public class remove_element_in_array {
    public static void main(String[] args) {
        int[] arrayInt = {4, 6, 8, 1, 2, 3, 0, 9, 10, 14};
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(Arrays.toString(arrayInt));
            System.out.print("Input number u want to remove: ");
            int index = scanner.nextInt();
            boolean flag = false;
            for (int i = 0; i < arrayInt.length; i++) {
                if (arrayInt[i] == index) {
                    flag = true;
                    arrayInt[i] = arrayInt[i + 1];
                    continue;
                }
                if (flag && i == arrayInt.length - 1){
                    arrayInt[i] = 0;
                    continue;
                }
                if (flag) {
                    arrayInt[i] = arrayInt[i + 1];
                }
            }
        }
    }
}
