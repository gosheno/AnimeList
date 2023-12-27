package oop.animelist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class EnterPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;


    @FXML
    void initialize() {
        back_button.setOnAction(actionEvent -> {
            back_button.getScene().getWindow().hide();
            HelloController.OpenNewScene(back_button, "Hello-view.fxml");
        });

    }
}