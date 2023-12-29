package oop.animelist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import logic.models.Anime;
import logic.services.AnimeService;

import java.net.URL;
import java.util.ResourceBundle;

public class PopupPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField DestTextFild;

    @FXML
    private Button edit_button;

    @FXML
    private TextField sourceTextFild;

    @FXML
    void initialize() {
        edit_button.setOnAction(actionEvent -> {

            edit_button.getScene().getWindow().hide();
            AnimeService animeService = new AnimeService();
            String source = sourceTextFild.getText().trim();

            Anime anime = animeService.getAnime(EnterPageController.destText, MainPageController.currentUser);
            if (anime!= null){
                anime.setName(source);
                animeService.updateAnime(anime);
            }

            MainPageController.OpenNewScene(edit_button, "EnterPage.fxml");

        });
    }

}
