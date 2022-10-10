package P7_Annagram;

public class Solution {
    public static boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();
        if (s.length() != t.length()) return false;
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-97] += 1;
            chars[t.charAt(i)-97] -= 1;
        }
        for (char c: chars){
            if (c != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        if (isAnagram("conmeo","conome")){
            System.out.println("Annagram");
        }
        else System.out.println("no annagram");
//        System.out.println((int)'Z');
    }
}
