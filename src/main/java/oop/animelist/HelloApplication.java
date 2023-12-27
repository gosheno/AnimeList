package oop.animelist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.models.Anime;
import logic.models.User;
import logic.services.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Your anime list!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        Test();

        launch();
    }

    public static void Test()throws SQLException {
        UserService userService = new UserService();
        User user = new User("Masha","hello");
        userService.saveUser(user);
        Anime AOT = new Anime("Attack On Tytan");
        AOT.setUser(user);
        user.addAnime(AOT);
        Anime TG = new Anime("Tokyo Ghoul");
        TG.setUser(user);
        user.addAnime(TG);
        userService.updateUser(user);
    }

}
