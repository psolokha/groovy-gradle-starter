package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeRunner {
    public static void main(String[] args) {

        ZonedDateTime now = ZonedDateTime.now(); // Дата и время с часовыми поясами
        System.out.println(now);

        Instant nowInstant = now.toInstant();
        long toEpochMilli = nowInstant.toEpochMilli();
        System.out.println(toEpochMilli);

        ZonedDateTime tomorrow = now.plus(1, ChronoUnit.DAYS);
        System.out.println(tomorrow);

        ZonedDateTime newDay = tomorrow.truncatedTo(ChronoUnit.DAYS); // Обнулены счетчики до ДНЕЙ

        LocalDateTime localNow = LocalDateTime.now();

        System.out.println(localNow);

        LocalDateTime setDate = LocalDateTime.of(2023, 8, 5,14,0,0); // 2023-08-05 14:00:00
        System.out.println(setDate);

        LocalDateTime newDate = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT); // 2023-08-04 00:00
        System.out.println(newDate);

        LocalTime utcTime = LocalTime.now(ZoneOffset.UTC);
        System.out.println(utcTime);
    }
}
