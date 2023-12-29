package oop.animelist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.models.Anime;
import logic.services.AnimeService;
import java.util.Optional;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EnterPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab TabPublic;

    @FXML
    private Tab TabUser;

    @FXML
    private Button edit_button;



    @FXML
    private Button add_Button;

    @FXML
    private Button del_Button;

    @FXML
    private TextField Textfield;
    @FXML
    private VBox VboxPublic;

    @FXML
    private VBox VboxUser;

    @FXML
    private Button back_button;



    @FXML
    void initialize() {
        VboxPublicSet();
        VboxUserSet();

        back_button.setOnAction(actionEvent -> {
            MainPageController.OpenNewScene(back_button, "MainPage.fxml");
        });

        del_Button.setOnAction(actionEvent -> {
            AnimeService animeService = new AnimeService();
            String name = Textfield.getText().trim();
            Anime anime = animeService.getAnime(name, MainPageController.currentUser);
            if (anime!= null){
                animeService.deleteAnime(anime);
            }
            MainPageController.OpenNewScene(del_Button, "EnterPage.fxml");

        });

        add_Button.setOnAction(actionEvent -> {
            AnimeService animeService = new AnimeService();
            String name = Textfield.getText().trim();
            Anime tr = new Anime(name);
            tr.setUser(MainPageController.currentUser);
            animeService.updateAnime(tr);
            MainPageController.OpenNewScene(add_Button, "EnterPage.fxml");
        });

        edit_button.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader(AnimeStoreApp.class.getResource("PopupPage.fxml"));
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

        });

    }


    public void VboxPublicSet() {
        AnimeService animeService = new AnimeService();
        List<String> data = animeService.getAnimeListAll();
        for (String str : data) {

            VboxPublic.getChildren().add(new Text(str));

        }
    }

    public void VboxUserSet(){
        AnimeService animeService = new AnimeService();
        List<String> data = animeService.getAnimeListUser(MainPageController.currentUser);
        for (String str : data )
        {
            VboxUser.getChildren().add(new Text(str));
        }

    }
}
