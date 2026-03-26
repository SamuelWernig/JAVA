module at.htlle.sam.habittrackerselfmade {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlle.sam.habittrackerselfmade to javafx.fxml;
    exports at.htlle.sam.habittrackerselfmade;
}