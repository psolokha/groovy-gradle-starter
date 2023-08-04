package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimePractice {
    public static void main(String[] args) {
        // #1
        LocalDateTime time1 = LocalDateTime.of(2020, 6, 25, 19, 47);
        LocalDateTime timePlus3Months = time1.plusMonths(3);
//        System.out.println(timePlus3Months.toLocalDate());
//        System.out.println(timePlus3Months.toLocalTime());
        LocalDate t1LD = LocalDate.from(timePlus3Months);
        LocalTime t1LT = LocalTime.from(timePlus3Months);
        System.out.println(timePlus3Months);
        System.out.println(t1LD);
        System.out.println(t1LT);

        //#2
        LocalDate todayDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(todayDate.format(format));

        //#3
        String dateString = "26-03-1968T09:24";
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime outLDTDate = LocalDateTime.parse(dateString, dtf1);
        System.out.println(outLDTDate);
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
//        LocalDateTime outLDTDate = LocalDateTime.of(
//                                    LocalDate.parse(
//                                            dateString.split("T")[0],dateFormat),
//                                    LocalTime.parse(
//                                            dateString.split("T")[1], timeFormat));


        // #4
//
        Instant instant = outLDTDate.toInstant(
                ZoneId.of("America/Chicago")
                        .getRules()
                        .getOffset(outLDTDate));
        System.out.println(instant.toEpochMilli());

        // #5
        LocalDate todayLD = LocalDate.now();
        LocalDate dateLD = LocalDate.of(2018, 07,07);
//        LocalDate newDateLD = todayLD.minusDays(dateLD.toEpochDay());
//        System.out.println(newDateLD.toEpochDay());
//        System.out.println(Period.between(dateLD, todayLD));
        System.out.println(ChronoUnit.DAYS.between(todayLD, dateLD));

        // #6
        System.out.println(
                Duration.between(dateLD.atStartOfDay(),
                                    todayLD.atStartOfDay()).getSeconds());

        System.out.println(todayLD.toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.UTC)
                - dateLD.toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.UTC));

        // #7

        Instant instant1 = Instant.now();

        ZonedDateTime zndDT = instant1.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println(zndDT);

        // #8
        LocalDate ld8 = LocalDate.now();

        LocalDate newLD = ld8.with(temporal -> temporal.plus(42, ChronoUnit.DAYS));
        System.out.println(newLD);
    }


}
