package at.htlle.sam.javafx_arbeitszeiterfassung.service;

import java.time.Duration;
import java.time.LocalTime;

public class TimeCalculator {

    public static double calculateHours(LocalTime start, LocalTime end, int breakMinutes) {

        long totalMinutes = Duration.between(start, end).toMinutes();
        long netMinutes = totalMinutes - breakMinutes;

        return netMinutes / 60.0;
    }
}