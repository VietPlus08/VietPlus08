package ss2;

import java.util.Scanner;

public class create_menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        loop:
        while (true) {
            System.out.println("----------------------");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Choose your choice: ");
            switch (scanner.nextLine()) {
                case "1":
                    printRectangle();
                    break;
                case "2":
                    printSquareTriangle();
                    break;
                case "3":
                    printIsoscelesTriangle();
                    break;
                default:
                    break loop;
            }
        }

    }

    private static void printIsoscelesTriangle() {
        int n = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" ");
                if (j >= 5 - 1 - i){
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }

    private static void printSquareTriangle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    private static void printRectangle() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
