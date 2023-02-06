package s11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ex5_palindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("abcba"));;
    }
    private static boolean checkPalindrome(String data){
        byte[] bytes = data.getBytes();
        int index = bytes.length;
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<Character>() {
        };
        for (int i = 0; i < bytes.length; i++) {
            stack.push((char) bytes[i]);
            queue.add((char) bytes[i]);
        }
        while (!stack.empty()){
            if (stack.pop() != queue.poll()){
                return false;
            }
        }
        return true;
    }
}
