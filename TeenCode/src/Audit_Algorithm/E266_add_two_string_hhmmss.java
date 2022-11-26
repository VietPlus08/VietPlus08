package Audit_Algorithm;

import java.util.Scanner;

public class E266_add_two_string_hhmmss {
    public static void main(String[] args) {
        String str1 = "05:45:23";
        String str2 = "12:23:45";
        System.out.println("add string : " + str1 + " & " +str2 );
        plus(str1, str2);
    }

    private static void plus(String str1, String str2) {
        int time1 = Integer.parseInt(str1.substring(0,2)) * 3600 +
                Integer.parseInt(str1.substring(3,5)) * 60 + Integer.parseInt(str1.substring(6,7));
        int time2 = Integer.parseInt(str2.substring(0,2)) * 3600 +
                Integer.parseInt(str2.substring(3,5)) * 60 + Integer.parseInt(str2.substring(6,7));
        int plusTime = time1 + time2;
        int hh_time = plusTime / 3600;
        int mm_time = plusTime % 3600 / 60;
        int ss_time = plusTime % 3600 % 60;
        System.out.printf("Result : %d:%d:%d", hh_time,mm_time,ss_time);
    }



}
