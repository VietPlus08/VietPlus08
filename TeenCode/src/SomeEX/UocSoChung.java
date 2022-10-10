package SomeEX;

import java.util.Scanner;

public class UocSoChung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so a: ");
        int a = Math.abs(scanner.nextInt());
        System.out.println("Nhap vao so b: ");
        int b = Math.abs(scanner.nextInt());
        while (a != b){
            if (a > b){
                a = a - b;
            } else {
                b = b - a;
            }
        }
        System.out.println(a);


    }
}
