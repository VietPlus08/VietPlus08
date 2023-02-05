package s11;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ex2_count_frequency_of_word_in_string {
    public static void main(String[] args) {
        String string = "thanh pho da nang";
        Map<Character, Integer> map = countFrequencyOfWord(string.toLowerCase());
        for (Map.Entry entry: map.entrySet()){
            System.out.println(entry.getKey() + " has frequency is: " + entry.getValue());
        }
    }

    private static Map<Character, Integer> countFrequencyOfWord(String string) {
        Map<Character, Integer> map = new TreeMap<>();
        byte[] bytes = string.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            Character character = (char) bytes[i];
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
                continue;
            }
            map.put(character, 1);
        }
        return map;
    }

}
