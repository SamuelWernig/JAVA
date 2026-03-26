package at.htlle.sam.habittracker.controller;

import at.htlle.sam.habittracker.model.Habit;
import at.htlle.sam.habittracker.service.HabitService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {

    @FXML
    private TableView<Habit> habitTable;

    @FXML
    private TableColumn<Habit, String> nameColumn;

    @FXML
    private TableColumn<Habit, String> categoryColumn;

    @FXML
    private TableColumn<Habit, Integer> targetColumn;

    @FXML
    private Label streakLabel;

    @FXML
    private ProgressBar weeklyProgressBar;

    private final HabitService habitService = HabitService.getInstance();
    private final ObservableList<Habit> observableHabits = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));
        categoryColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCategory()));
        targetColumn.setCellValueFactory(data ->
                new SimpleObjectProperty<>(data.getValue().getTargetPerWeek()));

        observableHabits.setAll(habitService.getHabits());
        habitTable.setItems(observableHabits);
    }

    @FXML
    private void handleAddHabit() {
        Habit newHabit = new Habit(1, "Sport", "Gesundheit", 4);
        habitService.addHabit(newHabit);
        observableHabits.setAll(habitService.getHabits());
    }

    @FXML
    private void handleDeleteHabit() {
        Habit selected = habitTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            habitService.removeHabit(selected);
            observableHabits.setAll(habitService.getHabits());
        }
    }

    @FXML
    private void handleMarkDone() {
        Habit selected = habitTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            habitService.markHabitForToday(selected.getId(), true);
        }
    }

    @FXML
    private void handleLoadCsv() {
    }

    @FXML
    private void handleSaveCsv() {
    }
}