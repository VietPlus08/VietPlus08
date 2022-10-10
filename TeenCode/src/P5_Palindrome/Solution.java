package P5_Palindrome;

import java.util.Stack;

public class Solution {
    public static boolean isPalindrome(String s) {
        String nonAlphanumeric = ":;,.!@#$%^&*() ";
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // Dùng kiểu kiểm tra isDigit isLetter để tối ưu hơn
            if (Character.isLetterOrDigit(str.charAt(i))){
//                sb.append(str.charAt(i));
            }
//            if (!nonAlphanumeric.contains(String.valueOf(str.charAt(i)))){
//                sb.append(str.charAt(i));
//            }
        }
        System.out.println(sb);
        for (int i = 0; i < sb.length()/2; i++) {
            if (sb.charAt(i)!=sb.charAt(sb.length()-(i+1)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        if (isPalindrome("A man, a plan, a canal: Panama")){
            System.out.println("true");
        } else {
            System.out.println("false");

        }
    }
}
