module oop.animelist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens oop.animelist to javafx.fxml;
    exports oop.animelist;
}