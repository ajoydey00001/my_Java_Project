package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainMenuController {
    private Main main;

    @FXML
    private Button playerList;
    @FXML
    private Button players;
    @FXML
    private Button clubs;
    @FXML
    private Button sell;
    @FXML
    private Button buy;
    @FXML
    private Button exited;
    @FXML
    private Label menu;

    public void init(String s) {
        menu.setText(s);
    }
    @FXML
    public void playerListAction(ActionEvent actionEvent) {
        if(main.getPlayerList()== null){
            try {
                main.showClubPlayerListAlertPage("Error ! There is no player in the playerList");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            try {
                main.showClubPlayerListPage();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    @FXML
    public void playerAction(ActionEvent actionEvent) {
        try {
            main.showPlayerSearchingOptionPage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void clubAction(ActionEvent actionEvent) {
        try {
            main.showClubSearchingOptionPage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void sellAction(ActionEvent actionEvent) {
        try {
            main.showSellingPage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void buyAction(ActionEvent actionEvent) {

            main.buying();
    }
    @FXML
    public void exitAction(ActionEvent actionEvent) {
        main.setFlag(2);
        javafx.application.Platform.exit();

    }
    void setMain(Main main) {
        this.main = main;
    }

}
