package at.htlle.sam.habittracker_v1_0;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalDate;

public class HabitService {
    private final CsvStorage storage;
    private final ObservableList<Habit> habits = FXCollections.observableArrayList();

    public HabitService(CsvStorage storage) {
        this.storage = storage;
    }

    public ObservableList<Habit> getHabits() {
        return habits;
    }

    public void load() throws IOException {
        habits.setAll(storage.loadHabits());
    }

    public void save() throws IOException {
        storage.saveHabits(habits);
    }

    public boolean addHabit(String name, String category) {
        if (name == null || name.isBlank()) return false;

        boolean exists = habits.stream()
                .anyMatch(h -> h.getName().equalsIgnoreCase(name));

        if (exists) return false;

        habits.add(new Habit(name, category));
        return true;
    }

    public void removeHabit(Habit h) {
        habits.remove(h);
    }

    public void setDone(Habit h, LocalDate date, boolean done) {
        h.setDoneOn(date, done);
    }
}