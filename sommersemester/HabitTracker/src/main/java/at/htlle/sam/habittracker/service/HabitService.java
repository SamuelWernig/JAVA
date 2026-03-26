package at.htlle.sam.habittracker.service;

import at.htlle.sam.habittracker.model.Habit;
import at.htlle.sam.habittracker.model.HabitEntry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HabitService {

    private static HabitService instance;

    private final List<Habit> habits = new ArrayList<>();
    private final List<HabitEntry> entries = new ArrayList<>();

    private HabitService() {
    }

    public static HabitService getInstance() {
        if (instance == null) {
            instance = new HabitService();
        }
        return instance;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public List<HabitEntry> getEntries() {
        return entries;
    }

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

    public void removeHabit(Habit habit) {
        habits.remove(habit);
        entries.removeIf(e -> e.getHabitId() == habit.getId());
    }

    public void markHabitForToday(int habitId, boolean completed) {
        LocalDate today = LocalDate.now();

        for (HabitEntry entry : entries) {
            if (entry.getHabitId() == habitId && entry.getDate().equals(today)) {
                entry.setCompleted(completed);
                return;
            }
        }

        entries.add(new HabitEntry(habitId, today, completed));
    }
}