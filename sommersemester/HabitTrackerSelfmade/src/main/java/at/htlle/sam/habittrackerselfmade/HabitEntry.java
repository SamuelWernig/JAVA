package at.htlle.sam.habittrackerselfmade;

import java.time.LocalDate;

public class HabitEntry {
    private Integer habitId;
    private LocalDate date;
    private boolean completed;

    public HabitEntry(Integer habitId, LocalDate date, boolean completed) {
        this.habitId = habitId;
        this.date = date;
        this.completed = completed;
    }

    public Integer getHabitId() {
        return habitId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDate getDate() {
        return date;
    }
}
