package at.htlle.sam.habittracker_v1_0;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.io.IOException;
import java.time.LocalDate;

public class HabitTrackerController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField categoryField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TableView<Habit> tableView;

    @FXML
    private TableColumn<Habit, String> nameCol;

    @FXML
    private TableColumn<Habit, String> categoryCol;

    @FXML
    private TableColumn<Habit, Boolean> doneCol;

    @FXML
    private TableColumn<Habit, String> lastDoneCol;

    @FXML
    private TableColumn<Habit, Number> streakCol;

    @FXML
    private TableColumn<Habit, Number> totalCol;

    private HabitService service;

    public void setService(HabitService service) {
        this.service = service;
        tableView.setItems(service.getHabits());
    }

    @FXML
    public void initialize() {
        datePicker.setValue(LocalDate.now());

        tableView.setEditable(true);
        doneCol.setEditable(true);

        nameCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getName()));

        categoryCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getCategory()));

        doneCol.setCellValueFactory(data -> {
            Habit habit = data.getValue();
            LocalDate selectedDate = datePicker.getValue();

            SimpleBooleanProperty prop = new SimpleBooleanProperty(habit.isDoneOn(selectedDate));

            prop.addListener((obs, oldVal, newVal) -> {
                if (service != null) {
                    service.setDone(habit, selectedDate, newVal);
                    saveAndRefresh();
                }
            });

            return prop;
        });

        doneCol.setCellFactory(tc -> new CheckBoxTableCell<>());

        lastDoneCol.setCellValueFactory(data -> {
            LocalDate lastDone = data.getValue().getLastDoneDate();
            return new SimpleStringProperty(lastDone == null ? "-" : lastDone.toString());
        });

        streakCol.setCellValueFactory(data ->
                new SimpleIntegerProperty(data.getValue().getCurrentStreak()));

        totalCol.setCellValueFactory(data ->
                new SimpleIntegerProperty(data.getValue().getTotalDoneCount()));

        datePicker.valueProperty().addListener((obs, oldV, newV) -> tableView.refresh());
    }

    @FXML
    private void handleAddHabit() {
        if (service == null) {
            return;
        }

        boolean ok = service.addHabit(nameField.getText(), categoryField.getText());

        if (!ok) {
            showAlert("Habit konnte nicht hinzugefügt werden.");
            return;
        }

        nameField.clear();
        categoryField.clear();
        saveAndRefresh();
    }

    @FXML
    private void handleRemoveHabit() {
        if (service == null) {
            return;
        }

        Habit selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            service.removeHabit(selected);
            saveAndRefresh();
        }
    }

    @FXML
    private void handleToday() {
        datePicker.setValue(LocalDate.now());
        tableView.refresh();
    }

    private void saveAndRefresh() {
        try {
            service.save();
            tableView.refresh();
        } catch (IOException e) {
            showAlert("Fehler beim Speichern: " + e.getMessage());
        }
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}