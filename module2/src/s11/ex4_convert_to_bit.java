package s11;

import java.util.Stack;

public class ex4_convert_to_bit {
    public static void main(String[] args) {
        System.out.println(convert(2));
    }
    private static int convert(int data){
        Stack<Integer> stack = new Stack<>();
        while (data / 2 != 0){
            stack.push(data % 2);
            data = data / 2;
        }
        stack.push(data);
        int result = 0;
        while (!stack.empty()){
            result = result * 10 + stack.pop();
        }
        return result;
    }
}
