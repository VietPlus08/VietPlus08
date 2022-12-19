package ss3;

import java.util.Scanner;

public class sum_element_diagonal_in_array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input i: ");
        int row = scanner.nextInt();

        int[][] arr = new int[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print("Input arr[" + i + "][" + j + "] = ");
                arr[i][j] = scanner.nextInt();
            }
        }

        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += arr[i][i];
        }
        System.out.println("Sum elements of array diagonal: " + sum);
    }
}
