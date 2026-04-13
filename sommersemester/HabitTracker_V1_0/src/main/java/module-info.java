module at.htlle.sam.habittracker_v1_0 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.media;

    exports at.htlle.sam.habittracker_v1_0;
    opens at.htlle.sam.habittracker_v1_0 to javafx.fxml;
}