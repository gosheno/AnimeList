package oop.animelist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import logic.models.User;
import logic.services.AnimeService;
import oop.animelist.MainPageController;
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
    private VBox VboxPublic;

    @FXML
    private VBox VboxUser;

    @FXML
    private Button back_button;

    @FXML
    private ScrollPane ScrollpanePublic;

    @FXML
    private ScrollPane ScrollpaneUser;

    @FXML
    void initialize() {
        VboxPublicSet();
        VboxUserSet(MainPageController.currentUser);
        back_button.setOnAction(actionEvent -> {
            MainPageController.OpenNewScene(back_button, "MainPage.fxml");
        });

    }

    public void VboxPublicSet() {
        AnimeService animeService = new AnimeService();
        List<String> data = animeService.getAnimeListAll();
        for (String str : data) {

            VboxPublic.getChildren().add(new Text(str));

        }
    }

    public void VboxUserSet(User currentuser){
        AnimeService animeService = new AnimeService();
        List<String> data = animeService.getAnimeListUser(currentuser);
        for (String str : data )
        {
            VboxUser.getChildren().add(new Text(str));
        }

    }
}
