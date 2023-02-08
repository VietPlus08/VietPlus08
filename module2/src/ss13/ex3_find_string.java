package ss13;

import java.util.Stack;

public class ex3_find_string {
    public static void main(String[] args) {
        String s = "Welcome";
        String result = findString(s);
        System.out.println("Sub string has biggest size: " + result);
    }

    private static String findString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> max = new Stack<>();
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.empty() || list.peek() < s.charAt(i)) {
                list.push(s.charAt(i));
            } else {
                if (max.size() < list.size()) {
                    max.clear();
                    max.addAll(list);
                    list.clear();
                }
            }
        }
        max.forEach(result::append);
        return String.valueOf(result);
    }
}
