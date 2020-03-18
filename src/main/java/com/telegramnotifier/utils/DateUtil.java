/*
 * Copyright (C) Whirl Software PTE LTD. 2014-2019 - All Rights Reserved
 * 600 North Bridge Road, Parkview Square #15-10, Singapore
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * License: see file "LICENSE.txt"
 */
package com.telegramnotifier.utils;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

@UtilityClass
public class DateUtil {
    private final String[] calendarMonthRu =
        {"Января", "Февраля", "Марта", "Апреля", "Мая", "Июня", "Июля", "Августа", "Сентября", "Октября", "Ноября", "Декабря"};

    public Date parseDateAndTimeFrom(String date, String time) throws ParseException {
        List<String> monthRu = Arrays.asList(calendarMonthRu);
        String[] dateAndMonth = date.split(" ");
        String day = dateAndMonth[0];
        String monthStr = dateAndMonth[1];
        int month = IntStream.range(0, monthRu.size())
            .filter(i -> calendarMonthRu[i].equalsIgnoreCase(monthStr)).findAny().orElse(-1) + 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        int year = GregorianCalendar.getInstance().get(Calendar.YEAR);
        String datePattern = month + "-" + day + "-" + year + " " + time;
        return dateFormat.parse(datePattern);
    }
}
