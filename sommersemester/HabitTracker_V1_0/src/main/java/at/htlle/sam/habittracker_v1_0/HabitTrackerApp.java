package at.htlle.sam.habittracker_v1_0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class HabitTrackerApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        CsvStorage storage = CsvStorage.getInstance();
        HabitService service = new HabitService(storage);
        service.load();

        URL fxmlUrl = HabitTrackerApp.class.getResource("/at/htlle/sam/habittracker_v1_0/habit-tracker-view.fxml");
        if (fxmlUrl == null) {
            throw new RuntimeException("FXML-Datei nicht gefunden.");
        }

        FXMLLoader loader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(loader.load(), 900, 550);

        URL cssUrl = HabitTrackerApp.class.getResource("/at/htlle/sam/habittracker_v1_0/style.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }

        HabitTrackerController controller = loader.getController();
        controller.setService(service);

        stage.setTitle("Habit Tracker mit JavaFX + CSV");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}