package s11;

import java.util.Arrays;
import java.util.Stack;

public class ex1_reverse_array {
    public static void main(String[] args) {
        int[] ints = {1,2,4,6,8};
        System.out.println(Arrays.toString(reverse(ints)));
    }

    private static int[] reverse(int[] ints) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ints.length; i++) {
            stack.push(ints[i]);
        }
        for (int i = 0; i < ints.length; i++) {
            ints[i] = stack.pop();
        }
        return ints;
    }
}
