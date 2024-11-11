package com.freelance.bitcoin.utils.automation;

import java.time.LocalDateTime;
import java.util.Date;

public class CreateSku {
    public static String random() {
        LocalDateTime dateTime = LocalDateTime.now();
        Date date    = new Date();
        String day   = String.format("%s%s", (dateTime.getDayOfMonth() > 9 ? "" : "0"), dateTime.getDayOfMonth());
        String month = String.format("%s%s", (dateTime.getMonthValue() > 9 ? "" : "0"), dateTime.getMonthValue());
        String year  = String.format("%s"  , dateTime.getYear());
        String hour  = String.format("%s%s", (dateTime.getHour() > 9 ? "" : "0"), dateTime.getHour());
        String minute  = String.format("%s%s", (dateTime.getMinute() > 9 ? "" : "0"), dateTime.getMinute());
        String second  = String.format("%s%s", (dateTime.getSecond() > 9 ? "" : "0"), dateTime.getSecond());
        String minisecond  = String.format("%.3s", date.getTime());

        String sku = String.format("%s%s%s.%s%s%s.%s", day, month, year, hour, minute, second, minisecond);
        return sku;
    }
}
