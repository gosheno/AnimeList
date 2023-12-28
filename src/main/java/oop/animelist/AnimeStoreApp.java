package oop.animelist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.models.Anime;
import logic.models.User;
import logic.services.AnimeService;
import logic.services.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        test();
        launch();
    }
    public static void test() {
        AnimeService animeService = new AnimeService();
        UserService userService = new UserService();
        userService.remove_all();
        animeService.remove_all();
        User aaa = new User("aaa", "aaaa");
        Anime a = new Anime("a");
        Anime aa = new Anime("aa");

        a.setUser(aaa);
        aa.setUser(aaa);
        User bbb = new User("bbb", "aaaa");
        Anime b = new Anime("b");
        Anime bb = new Anime("bb");
        b.setUser(bbb);
        bb.setUser(bbb);

        List<Anime> anime = new ArrayList<>();
        anime.add(b);
        anime.add(bb);
        bbb.setAnimes(anime);
        userService.saveUser(bbb);

        anime = new ArrayList<>();
        anime.add(a);
        anime.add(aa);
        aaa.setAnimes(anime);
        userService.saveUser(aaa);


    }



}
