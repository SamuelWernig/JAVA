package at.htlle.sam.habittracker.service;

import at.htlle.sam.habittracker.model.HabitEntry;

import java.time.LocalDate;
import java.util.List;

public class StatisticsService {

    public int calculateStreak(int habitId, List<HabitEntry> entries) {
        int streak = 0;
        LocalDate currentDate = LocalDate.now();

        while (true) {
            LocalDate finalDate = currentDate;

            boolean completedOnDate = entries.stream()
                    .anyMatch(entry ->
                            entry.getHabitId() == habitId &&
                                    entry.getDate().equals(finalDate) &&
                                    entry.isCompleted());

            if (completedOnDate) {
                streak++;
                currentDate = currentDate.minusDays(1);
            } else {
                break;
            }
        }

        return streak;
    }

    public int countCompletedInLast7Days(int habitId, List<HabitEntry> entries) {
        LocalDate today = LocalDate.now();
        LocalDate startDate = today.minusDays(6);

        return (int) entries.stream()
                .filter(entry -> entry.getHabitId() == habitId)
                .filter(HabitEntry::isCompleted)
                .filter(entry ->
                        !entry.getDate().isBefore(startDate) &&
                                !entry.getDate().isAfter(today))
                .count();
    }

    public double calculateWeeklyProgress(int habitId, List<HabitEntry> entries, int targetPerWeek) {
        if (targetPerWeek <= 0) {
            return 0.0;
        }

        int completedCount = countCompletedInLast7Days(habitId, entries);
        double progress = (double) completedCount / targetPerWeek;

        return Math.min(progress, 1.0);
    }

    public boolean isWeeklyGoalReached(int habitId, List<HabitEntry> entries, int targetPerWeek) {
        int completedCount = countCompletedInLast7Days(habitId, entries);
        return completedCount >= targetPerWeek;
    }
}