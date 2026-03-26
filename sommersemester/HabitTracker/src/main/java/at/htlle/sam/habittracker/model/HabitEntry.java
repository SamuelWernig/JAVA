package at.htlle.sam.habittracker.model;

import java.time.LocalDate;

public class HabitEntry {
    private int habitId;
    private LocalDate date;
    private boolean completed;

    public HabitEntry(int habitId, LocalDate date, boolean completed) {
        this.habitId = habitId;
        this.date = date;
        this.completed = completed;
    }

    public int getHabitId() {
        return habitId;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}