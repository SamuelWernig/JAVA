module at.htlle.sam.pongimplementation {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlle.sam.pongimplementation to javafx.fxml;
    exports at.htlle.sam.pongimplementation;
}