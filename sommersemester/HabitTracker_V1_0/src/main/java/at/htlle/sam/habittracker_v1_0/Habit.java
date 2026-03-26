package at.htlle.sam.habittracker_v1_0;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class Habit {
    private String name;
    private String category;
    private Set<LocalDate> doneDates = new TreeSet<>();

    public Habit(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public Set<LocalDate> getDoneDates() { return doneDates; }

    public boolean isDoneOn(LocalDate date) {
        return doneDates.contains(date);
    }

    public void setDoneOn(LocalDate date, boolean done) {
        if (done) doneDates.add(date);
        else doneDates.remove(date);
    }

    public LocalDate getLastDoneDate() {
        return doneDates.isEmpty() ? null : ((TreeSet<LocalDate>) doneDates).last();
    }

    public int getTotalDoneCount() {
        return doneDates.size();
    }

    public int getCurrentStreak() {
        if (doneDates.isEmpty()) return 0;

        TreeSet<LocalDate> sorted = new TreeSet<>(doneDates);
        LocalDate current = sorted.last();
        int streak = 1;

        while (sorted.contains(current.minusDays(1))) {
            current = current.minusDays(1);
            streak++;
        }

        return streak;
    }
}