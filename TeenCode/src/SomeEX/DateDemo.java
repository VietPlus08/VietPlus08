import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class DateDemo {
    public static void main(String[] args) {
        Date date = Date.valueOf(LocalDate.now());
        Date date1 = Date.valueOf("2022-10-28");
        System.out.println(date1.toLocalDate());
        System.out.println(Period.between(date1.toLocalDate(),LocalDate.now()).getDays());

    }
}
