module at.htlle.sam.demo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlle.sam.demo1 to javafx.fxml;
    exports at.htlle.sam.demo1;
}