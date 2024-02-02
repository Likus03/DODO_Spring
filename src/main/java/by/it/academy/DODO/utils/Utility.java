package by.it.academy.DODO.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Utility {
    public static LocalDate[] getWeek(LocalDate date) {
        LocalDate[] week = new LocalDate[2];

        week[0] = date.with(DayOfWeek.MONDAY);
        week[1] = date.with(DayOfWeek.SUNDAY);
        return week;
    }
}
