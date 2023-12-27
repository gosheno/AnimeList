module oop.animelist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;

    opens oop.animelist to javafx.fxml;
    exports oop.animelist;
}