package at.htlle.sam.habittrackerselfmade;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloController {
    @FXML
    private Label welcomeText;

    private TextField habitID

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Hobbittracker");
    }
}
