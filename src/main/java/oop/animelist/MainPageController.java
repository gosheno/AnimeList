package oop.animelist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.services.UserService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enter_button;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button reg_button;

    @FXML
    void initialize() {

        enter_button.setOnAction(actionEvent -> {
            String login = login_field.getText().trim();
            String password = password_field.getText().trim();
            if(!login.equals("") && !password.equals("")){
                login_user(login, password);
            }
        });
        reg_button.setOnAction(actionEvent -> {OpenNewScene(reg_button, "Reg_Page.fxml");});
    }

    private void login_user(String login, String password) {
        UserService userService = new UserService();
        if(userService.getUser(login, password)!=null){
            OpenNewScene(enter_button, "EnterPage.fxml");
        };
    }


    static public void OpenNewScene(Button button, String window){
        button.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader(AnimeStoreApp.class.getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
