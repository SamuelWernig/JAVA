package at.htlle.sam.javafx_arbeitszeiterfassung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getResource("/at/htlle/sam/javafx_arbeitszeiterfassung/arbeitszeiterfassung.fxml")
        );
        Scene scene = new Scene(loader.load(), 834, 800);
        scene.getStylesheets().add(
                getClass().getResource("/at/htlle/sam/javafx_arbeitszeiterfassung/style.css").toExternalForm()
        );
        stage.setTitle("Arbeitszeiterfassung");
        stage.setScene(scene);
        stage.show();
    }
}
