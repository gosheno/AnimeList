package oop.animelist;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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