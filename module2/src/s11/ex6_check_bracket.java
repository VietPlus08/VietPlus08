package s11;

import java.util.Stack;

public class ex6_check_bracket {
    public static void main(String[] args) {
        System.out.println(checkBracket("(1+2)x((3+4)+(2)"));
    }
    private static boolean checkBracket(String data){
        byte[] bytes = data.getBytes();
        Stack<Character> stack = new Stack<>();
        for (byte b: bytes){
            if ((char) b == '('){
                stack.push('(');
                continue;
            }
            if ((char) b == ')'){
                if (stack.pop()!= '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
