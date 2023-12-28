package oop.animelist;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import logic.models.User;
import logic.services.UserService;

import static oop.animelist.MainPageController.OpenNewScene;

public class RegPageController {

    @FXML
    private TextField login_reg;

    @FXML
    private PasswordField password_field;

    @FXML
    private PasswordField password_field_repeat;

    @FXML
    private Button reg_button;
    @FXML
    void initialize() {

        reg_button.setOnAction(actionEvent -> {
            String login = login_reg.getText().trim();
            String password = password_field.getText().trim();
            String passwordRepeat = password_field_repeat.getText().trim();
            UserService userService = new UserService();
            if (userService.regcheck(login) == 0){

                if(!login.equals("") && !password.equals("") && !passwordRepeat.equals("")
                        && password.equals(passwordRepeat)){
                    reg_user(login, password);
                }
            }


        });


   }


    private void reg_user(String login, String password) {


        UserService userService = new UserService();
        User user = new User(login,password);
        userService.saveUser(user);
        OpenNewScene(reg_button, "MainPage.fxml");
    }


}
