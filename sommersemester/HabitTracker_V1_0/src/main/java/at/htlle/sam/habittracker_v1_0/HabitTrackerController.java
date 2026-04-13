package at.htlle.sam.habittracker_v1_0;

import javafx.animation.PauseTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class HabitTrackerController {

    @FXML private TextField nameField;
    @FXML private ComboBox<String> categoryBox;
    @FXML private DatePicker datePicker;
    @FXML private TableView<Habit> tableView;
    @FXML private TableColumn<Habit, String> nameCol;
    @FXML private TableColumn<Habit, String> categoryCol;
    @FXML private TableColumn<Habit, Boolean> doneCol;
    @FXML private TableColumn<Habit, String> lastDoneCol;
    @FXML private TableColumn<Habit, Number> streakCol;
    @FXML private TableColumn<Habit, Number> totalCol;

    private HabitService service;

    private MediaPlayer successPlayer;
    private Stage successStage;

    private final Random random = new Random();
    private PauseTransition adTimer;

    private final List<String> adImages = List.of(
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung1.png",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung2.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung3.jpeg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung4.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung5.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung6.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung7.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung8.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung9.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung10.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung11.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung12.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung13.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung14.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung15.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung16.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung17.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung18.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung19.png",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung20.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung21.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung22.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung23.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung24.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung25.jpg",
            "/at/htlle/sam/habittracker_v1_0/werbung/werbung26.png"
    );

    public void setService(HabitService service) {
        this.service = service;
        tableView.setItems(service.getHabits());
    }

    @FXML
    public void initialize() {
        datePicker.setValue(LocalDate.now());

        categoryBox.getItems().addAll(
                "Sport",
                "Schule",
                "Gesundheit",
                "Lesen",
                "Coding",
                "Freizeit"
        );
        categoryBox.getSelectionModel().selectFirst();

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

                    if (allDoneForSelectedDate()) {
                        playSuccessVideo();
                    }
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

        startRandomAdTimer();
    }

    @FXML
    private void handleAddHabit() {
        if (service == null) {
            return;
        }

        String category = categoryBox.getValue();

        boolean ok = service.addHabit(nameField.getText(), category);
        if (!ok) {
            showAlert("Habit konnte nicht hinzugefügt werden.");
            return;
        }

        nameField.clear();
        categoryBox.getSelectionModel().clearSelection();
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

    @FXML
    private void handleSpamAds() {
        for (int i = 0; i < 20; i++) {
            PauseTransition delay = new PauseTransition(Duration.millis(i * 80));
            delay.setOnFinished(e -> showAdPopup());
            delay.play();
        }
    }

    private void saveAndRefresh() {
        try {
            service.save();
            tableView.refresh();
        } catch (IOException e) {
            showAlert("Fehler beim Speichern: " + e.getMessage());
        }
    }

    private boolean allDoneForSelectedDate() {
        LocalDate selectedDate = datePicker.getValue();

        if (service == null || service.getHabits().isEmpty()) {
            return false;
        }

        return service.getHabits().stream()
                .allMatch(h -> h.isDoneOn(selectedDate));
    }

    private void playSuccessVideo() {
        try {
            URL videoUrl = getClass().getResource("/at/htlle/sam/habittracker_v1_0/success.mp4");
            if (videoUrl == null) {
                showAlert("Video nicht gefunden: success.mp4");
                return;
            }

            if (successPlayer != null) {
                try {
                    successPlayer.dispose();
                } catch (Exception ignored) {
                }
            }

            if (successStage != null) {
                successStage.close();
            }

            Media media = new Media(videoUrl.toExternalForm());
            successPlayer = new MediaPlayer(media);

            MediaView mediaView = new MediaView(successPlayer);
            mediaView.setPreserveRatio(true);
            mediaView.setFitWidth(640);
            mediaView.setFitHeight(360);

            StackPane root = new StackPane(mediaView);
            root.setStyle("-fx-background-color: black;");

            Scene scene = new Scene(root, 640, 360);
            scene.setFill(javafx.scene.paint.Color.BLACK);

            successStage = new Stage();
            successStage.initStyle(StageStyle.UNDECORATED);
            successStage.setScene(scene);

            successPlayer.setOnReady(() -> {
                successStage.sizeToScene();
                successStage.centerOnScreen();
                successPlayer.play();
            });

            successPlayer.setOnError(() -> {
                showAlert("Video Fehler: " + successPlayer.getError());
            });

            successPlayer.setOnEndOfMedia(() -> {
                try {
                    successPlayer.dispose();
                } catch (Exception ignored) {
                }
                successStage.close();
            });

            successStage.show();

        } catch (Exception e) {
            showAlert("Fehler beim Abspielen: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void startRandomAdTimer() {
        if (adTimer != null) {
            adTimer.stop();
        }

        int seconds = 15 + random.nextInt(10);
        adTimer = new PauseTransition(Duration.seconds(seconds));

        adTimer.setOnFinished(e -> showAdPopup());
        adTimer.play();
    }

    private void showAdPopup() {
        try {
            String path = adImages.get(random.nextInt(adImages.size()));
            URL url = getClass().getResource(path);

            if (url == null) {
                startRandomAdTimer();
                return;
            }

            Image image = new Image(url.toExternalForm());
            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(420);
            imageView.setFitHeight(260);

            Button closeButton = new Button("X");
            closeButton.setStyle(
                    "-fx-background-color: #e53935;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 20;" +
                            "-fx-cursor: hand;"
            );
            closeButton.setMinSize(30, 30);
            closeButton.setPrefSize(30, 30);
            closeButton.setMaxSize(30, 30);

            HBox topBar = new HBox(closeButton);
            topBar.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
            topBar.setStyle("-fx-padding: 8; -fx-background-color: white;");

            BorderPane root = new BorderPane();
            root.setTop(topBar);
            root.setCenter(new StackPane(imageView));
            root.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 2;");

            Scene scene = new Scene(root, 440, 320);

            Stage adStage = new Stage();
            adStage.initStyle(StageStyle.UNDECORATED);
            adStage.initModality(Modality.NONE);
            adStage.setAlwaysOnTop(true);
            adStage.setScene(scene);

            Rectangle2D bounds = Screen.getPrimary().getVisualBounds();

            double stageWidth = 440;
            double stageHeight = 320;

            double minX = bounds.getMinX();
            double minY = bounds.getMinY();
            double maxX = bounds.getMaxX() - stageWidth;
            double maxY = bounds.getMaxY() - stageHeight;

            double randomX = minX + random.nextDouble() * Math.max(1, maxX - minX);
            double randomY = minY + random.nextDouble() * Math.max(1, maxY - minY);

            adStage.setX(randomX);
            adStage.setY(randomY);

            closeButton.setOnAction(e -> adStage.close());

            adStage.show();

            startRandomAdTimer();

        } catch (Exception e) {
            startRandomAdTimer();
            e.printStackTrace();
        }
    }

    private void showAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}