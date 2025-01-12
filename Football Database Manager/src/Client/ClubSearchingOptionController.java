package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ClubSearchingOptionController {
    private Main main;

    @FXML
    private Button salary;
    @FXML
    private Button age;
    @FXML
    private Button height;
    @FXML
    private Button total;
    @FXML
    private Button back;

    @FXML
    public void salaryAction(ActionEvent actionEvent) {
        try {
            main.searchClub1();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void ageAction(ActionEvent actionEvent) {
        try {
            main.searchClub2();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void heightAction(ActionEvent actionEvent) {
        try {
            main.searchClub3();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void totalAction(ActionEvent actionEvent) {
        try {
            main.searchClub4();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void backAction(ActionEvent actionEvent) {
        try {
            main.showMainMenuPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }
}
