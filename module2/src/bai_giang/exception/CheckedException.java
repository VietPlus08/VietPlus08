package bai_giang.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckedException {
    public static void main(String[] args) {
        System.out.println("Nhap vao 1 ngay");
        Scanner scanner = new Scanner(System.in);
        String dateAsString = scanner.nextLine();
//        Date date = convertToDate(dateAsString);
//        Date date = null;
//        try {
//            date = convertToDate2(dateAsString);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Date date = null;
        try {
            date = convertToDate3(dateAsString);
        } catch (DateException e) {
            e.printStackTrace();
        }
        System.out.println("Ngay da nhap: " + date);
    }

    private static Date convertToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        format.setLenient(false);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static Date convertToDate2(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        format.setLenient(false);
        Date date = format.parse(str);
        return date;
    }

    private static Date convertToDate3(String str) throws DateException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        format.setLenient(false);
        Date date = null;
        try {
            date = format.parse(str);
            if (date.after(new Date())) {
                throw new DateException("Ngay thang lon hon ngay hien tai");
            }

            if (date.getYear() < 0) {
                throw new DateException("Nam phai lon hon 1900");
            }
        } catch (ParseException e) {
            throw new DateException("Ngay thang bi sai format");
        }
        return date;
    }
}
