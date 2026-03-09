package at.htlle.sam.javafx_arbeitszeiterfassung.controller;

import at.htlle.sam.javafx_arbeitszeiterfassung.model.TimeEntry;
import at.htlle.sam.javafx_arbeitszeiterfassung.service.CsvService;
import at.htlle.sam.javafx_arbeitszeiterfassung.service.TimeCalculator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeController {

    // --- Form ---
    @FXML private DatePicker datePicker;
    @FXML private TextField projectField;
    @FXML private TextField startField;
    @FXML private TextField endField;
    @FXML private TextField breakField;
    @FXML private TextArea noteArea;

    // --- Table ---
    @FXML private TableView<TimeEntry> tableView;
    @FXML private TableColumn<TimeEntry, LocalDate> colDate;
    @FXML private TableColumn<TimeEntry, String> colProject;
    @FXML private TableColumn<TimeEntry, LocalTime> colStart;
    @FXML private TableColumn<TimeEntry, LocalTime> colEnd;
    @FXML private TableColumn<TimeEntry, Integer> colBreak;
    @FXML private TableColumn<TimeEntry, Double> colHours;
    @FXML private TableColumn<TimeEntry, String> colNote;

    private final ObservableList<TimeEntry> entries = FXCollections.observableArrayList();
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm");

    @FXML
    public void initialize() {
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colProject.setCellValueFactory(new PropertyValueFactory<>("project"));
        colStart.setCellValueFactory(new PropertyValueFactory<>("start"));
        colEnd.setCellValueFactory(new PropertyValueFactory<>("end"));
        colBreak.setCellValueFactory(new PropertyValueFactory<>("breakMinutes"));
        colHours.setCellValueFactory(new PropertyValueFactory<>("hours"));
        colNote.setCellValueFactory(new PropertyValueFactory<>("note"));

        tableView.setItems(entries);
    }

    @FXML
    private void onCalculateAndAdd() {
        try {
            // required
            if (datePicker.getValue() == null ||
                    projectField.getText().isBlank() ||
                    startField.getText().isBlank() ||
                    endField.getText().isBlank() ||
                    breakField.getText().isBlank()) {
                showError("Please fill all required fields.");
                return;
            }

            LocalDate date = datePicker.getValue();
            String project = projectField.getText().trim();

            LocalTime start = LocalTime.parse(startField.getText().trim(), TIME_FMT);
            LocalTime end = LocalTime.parse(endField.getText().trim(), TIME_FMT);

            int breakMin = Integer.parseInt(breakField.getText().trim());
            String note = noteArea.getText() == null ? "" : noteArea.getText();

            double hours = TimeCalculator.calculateHours(start, end, breakMin);

            TimeEntry entry = new TimeEntry(date, project, start, end, breakMin, hours, note);

            // Table update
            tableView.getItems().add(entry);
            tableView.refresh();

            // CSV save (append)
            CsvService.appendEntry(entry);

            // optional: clear after add
            onClear();

        } catch (IOException e) {
            showError("CSV write failed: " + e.getMessage());
        } catch (Exception e) {
            // catches: time format, number format, calculator validation
            showError("Invalid input: " + e.getMessage());
        }
    }

    @FXML
    private void onClear() {
        datePicker.setValue(null);
        projectField.clear();
        startField.clear();
        endField.clear();
        breakField.clear();
        noteArea.clear();
    }

    @FXML
    private void onExportCsv() {
        // because we already save on add
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("CSV Export");
        a.setContentText("Entries are saved automatically to time_entries.csv.");
        a.showAndWait();
    }

    private void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setHeaderText("Input error");
        a.setContentText(msg);
        a.showAndWait();
    }
}