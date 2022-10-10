package SomeEX;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String[] args) throws ParseException {
        Set<List<String>> customers = new HashSet<>();
        {
            customers.add(new ArrayList<>(Arrays.asList("1004", "6669","Quang Linh","Nghe An","Nam","18/08/1997","VIP")));
            customers.add(new ArrayList<>(Arrays.asList("1005", "6649","Thuc Quyen","Hue","Nu","18/09/1991","VIP")));
        }
        System.out.println(customers);
    }
}
