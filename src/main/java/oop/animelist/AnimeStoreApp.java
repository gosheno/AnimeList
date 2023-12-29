package oop.animelist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.services.AnimeService;
import logic.services.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class AnimeStoreApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AnimeStoreApp.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Your anime list!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {

        //test();
        launch();
    }
    public static void test() {
        AnimeService animeService = new AnimeService();
        UserService userService = new UserService();
        userService.remove_all();
        animeService.remove_all();


    }



}
