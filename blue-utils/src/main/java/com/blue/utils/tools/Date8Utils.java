package com.blue.utils.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * jdk8新版时间工具类
 *
 * @author lblue
 * @date 2018/4/25
 */
public class Date8Utils {
    /**
     * 详细时间
     */
    public static final String DETAIL = "yyyy-MM-dd HH:mm:ss";
    /**
     * 简单时间
     */
    public static final String SIMPLENESS = "yyyy-MM-dd";

    /**
     * 获取以前日期或者未来日期
     *
     * @param amountToAdd
     * @param unit
     * @return
     */
    public static Date plus(long amountToAdd, TemporalUnit unit) {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime plus = localDateTime.plus(amountToAdd, unit);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = plus.atZone(zoneId);

        Date date = Date.from(zdt.toInstant());

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern(DETAIL);
            String landing = plus.format(format);
            System.out.println(landing);
        } catch (DateTimeException ex) {
            ex.printStackTrace();
        }
        return date;
    }

    public static Date plusDays(long amountToAdd) {
        return plus(amountToAdd, ChronoUnit.DAYS);
    }

    public static Date plusWeeks(long amountToAdd) {
        return plus(amountToAdd, ChronoUnit.WEEKS);
    }

    public static Date plusMonth(long amountToAdd) {
        return plus(amountToAdd, ChronoUnit.MONTHS);
    }

    public static Date plusYears(long amountToAdd) {
        return plus(amountToAdd, ChronoUnit.YEARS);
    }

    /**
     * 获取当前日期
     *
     * @return
     */
//    public static Date now(ChronoZonedDateTime chronoZonedDateTime) {
//        Date date = null;
//
////        LocalDateTime localDateTime = LocalDateTime.now();
////        LocalDate localDate = LocalDate.now();
//
//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zdt = chronoZonedDateTime.atZone(zoneId);
//
//        date = Date.from(zdt.toInstant());
//        return date;
//    }
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static void get() {
        LocalDateTime localDateTime = LocalDateTime.now();

        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        System.out.println(Date.from(zonedDateTime.toInstant()));


//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zdt = localDateTime.atZone(zoneId);
//        return
    }

    /**
     * 格式化日期
     *
     * @return
     */
    public static Date qwer(String dateStr, String pattern) {
//        String goodFriday = "Apr 18 2014";
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
//            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
//            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
//        } catch (DateTimeParseException ex) {
//            System.out.printf("%s is not parsable!%n", goodFriday);
//            ex.printStackTrace();
//        }
        Date date = null;
        try {
            switch (pattern) {
                case SIMPLENESS:
                    date = toDate(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern)));
                    break;
                case DETAIL:
                    date = toDate(LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern)));
                    break;
            }

        } catch (Exception e) {
//            e.printStackTrace();
            //若报错，则使用旧版格式化日期
//            SimpleDateFormat simpleDateFormat = ;
            try {
                date = new SimpleDateFormat(pattern).parse(dateStr);
//                System.out.println(date);
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        return date;
    }

    public static void main(String[] args) {
        System.out.println(qwer("2018-05-01", SIMPLENESS));
        System.out.println(qwer("2018-05-04 01:02:3", DETAIL));
//        get();

//        String goodFriday = "01 18 2014";
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
//            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
//            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
//        } catch (DateTimeParseException ex) {
//            System.out.printf("%s is not parsable!%n", goodFriday);
//            ex.printStackTrace();
//        }
    }
}
