module at.htlle.sam.habittracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlle.sam.habittracker to javafx.fxml;
    exports at.htlle.sam.habittracker;
    exports at.htlle.sam.habittracker.model;
    opens at.htlle.sam.habittracker.model to javafx.fxml;
    exports at.htlle.sam.habittracker.controller;
    opens at.htlle.sam.habittracker.controller to javafx.fxml;
}