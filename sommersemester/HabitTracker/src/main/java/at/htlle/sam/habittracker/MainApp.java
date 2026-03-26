package at.htlle.sam.habittracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                MainApp.class.getResource("/at/htlle/sam/habittracker/main-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 900, 600);

        stage.setTitle("Habit Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}