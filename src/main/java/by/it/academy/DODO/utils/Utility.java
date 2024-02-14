package by.it.academy.DODO.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
/**
 * Utility class containing methods for working with dates.
 */
public class Utility {
    /**
     * Gets the start and end dates of the week for a given date.
     *
     * @param date The date for which the week should be retrieved.
     * @return An array containing the start date (Monday) and end date (Sunday) of the week.
     */
    public static LocalDate[] getWeek(LocalDate date) {
        LocalDate[] week = new LocalDate[2];

        week[0] = date.with(DayOfWeek.MONDAY);
        week[1] = date.with(DayOfWeek.SUNDAY);
        return week;
    }
}
