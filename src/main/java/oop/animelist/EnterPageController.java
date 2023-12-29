package oop.animelist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.models.Anime;
import logic.models.User;
import logic.services.AnimeService;
import logic.services.UserService;

import java.io.IOException;
import java.util.List;


public class EnterPageController {
    public static String destText;
    @FXML
    public Tab TabPublic;

    @FXML
    public Tab TabUser;

    @FXML
    public Button edit_button;


    @FXML
    private Button add_Button;

    @FXML
    private Button del_Button;

    @FXML
    private TextField Textfield;
    @FXML
    private GridPane Gridpane;

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
            destText = Textfield.getText().trim();
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
        UserService userService = new UserService();
        List<User> userList =  userService.findAllUsers();
        List<Anime> animeList;
        int i = 1;
        Gridpane.add(new Text("anime:"), 0, 0, 1, 2);
        Gridpane.add(new Text("user:"), 1, 0, 1, 2);

        Gridpane.setGridLinesVisible(true);
        for (User user : userList) {
            animeList = animeService.getaAnimeListById(user.getId());
            if(!animeList.isEmpty()){
                Gridpane.add(new Text(user.getName()), 0, i, 1, animeList.size());
                for(Anime anime: animeList){
                    i++;
                    Gridpane.add(new Text(anime.getName()), 1, i);
                }
            }
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
