package SomeEX;

public class SwapTwoNumber {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int[] c = {a,b};
        c = swap(a,b);
        System.out.println(a);
    }
    public static int[] swap(int a, int b){
        return new int[]{b,a};
    }
}
