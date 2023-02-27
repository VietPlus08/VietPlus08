package bai_tap_2.utils;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.stream.Collectors;

public class DisplayEnum {
    public static String convertToText(String s){
        return Arrays.stream(s.toLowerCase().split("_")).
                map(i -> i.substring(0,1).toUpperCase() + i.substring(1)).collect(Collectors.joining(" "));
    }
    public static <E extends Enum<E>> void displayMainMenu(Class<E> eClass){
        EnumSet.allOf(eClass).forEach(i -> {
            System.out.printf("%d. %s\n", i.ordinal() + 1, convertToText(i.name()));
        });
    }
}
