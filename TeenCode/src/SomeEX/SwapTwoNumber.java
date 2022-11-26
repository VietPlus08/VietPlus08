package SomeEX;

public class SwapTwoNumber {
    public static void main(String[] args) {
        int[] c = {5,6};
        swap(c);
        System.out.println("Ngoai ham " + c[0] + " "+ c[1]);

    }
    public static void swap(int[] c){
        int[] newArr = {6,5};
        c = newArr;
        System.out.println("Trong ham " + c[0] + " "+ c[1]);
    }
}
