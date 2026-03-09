module at.htlle.sam.javafx_arbeitszeiterfassung {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlle.sam.javafx_arbeitszeiterfassung.controller to javafx.fxml;

    opens at.htlle.sam.javafx_arbeitszeiterfassung.model to javafx.base;

    exports at.htlle.sam.javafx_arbeitszeiterfassung;
}