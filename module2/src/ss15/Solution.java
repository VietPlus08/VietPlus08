package ss15;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input all line of triangle ");
        System.out.println("Input length a: ");
        int a = scanner.nextInt();
        System.out.println("Input length b: ");
        int b = Integer.parseInt(scanner.next());
        System.out.println("Input length c: ");
        int c = Integer.parseInt(scanner.next());
        try{
            checkTriangle(a, b, c);
        } catch (IlegalTriangleException e) {
            e.printStackTrace();
        }
    }

    private static void checkTriangle(int a, int b, int c) throws IlegalTriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IlegalTriangleException("Lenghth nust be positive!");
        }
        if (a + b < c || a + c < b || b + c < a) {
            throw new IlegalTriangleException("Not triangle!");
        }
        System.out.println("Triangle");
    }

    private static class IlegalTriangleException extends Throwable {
        public IlegalTriangleException(String s) {
            super(s);
        }
    }
}
