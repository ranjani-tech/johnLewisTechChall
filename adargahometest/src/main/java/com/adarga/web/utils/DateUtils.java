package com.adarga.web.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public enum DateUtils {;

    public static Map.Entry<String, String> addDayToToday(Integer daysToAdd) {
        LocalDate today = LocalDate.now();
        today=today.plusDays(daysToAdd);

        HashMap<String,String> formattedDate = new HashMap<>();
        formattedDate.put(today.format(DateTimeFormatter.ofPattern("EEEE d MMMM yyyy")),today.format(DateTimeFormatter.ofPattern("d MMM")));

        Map.Entry<String, String> dayFormattedKeyValue;
        dayFormattedKeyValue = formattedDate.entrySet().iterator().next();

        return (dayFormattedKeyValue);
    }
}
