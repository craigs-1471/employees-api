package com.employeechallenge.employeesapi.miscmethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormat {

    // Convert string to LocalDate
    public static LocalDate getLocalDate(String date) {
        LocalDate startDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate parsedDate = LocalDate.parse(date, formatter);

        return parsedDate;
    }
    // Convert LocalDate to string
    public static String getStringLocalDate(LocalDate date) {
        String dateString = date.toString();
        String[] dateSplit = dateString.split("-");
        String newDateString = "";
        for (String string : dateSplit) {
            newDateString += string + " ";
        }
        String newDateSubString = newDateString.substring(0,10);
        return newDateSubString;
    }


}
