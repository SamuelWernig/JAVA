package at.htlle.sam.habittracker.util;

import at.htlle.sam.habittracker.model.Habit;

import java.util.List;

public class IdGenerator {

    public static int generateHabitId(List<Habit> habits) {

        int maxId = 0;

        for (Habit habit : habits) {
            if (habit.getId() > maxId) {
                maxId = habit.getId();
            }
        }

        return maxId + 1;
    }
}