package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.util.List;

public class PlayerSearchingOptionController {
    private Main main;

    @FXML
    private Button byPlayer;
    @FXML
    private Button byCountry;
    @FXML
    private Button byPosition;
    @FXML
    private Button bySalary;
    @FXML
    private Button countrywise;
    @FXML
    private Button back;

    @FXML
    public void byPlayerAction(ActionEvent actionEvent) {
        try {
            main.showByPlayerPage("Please Enter A Player Name");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void byCountryAction(ActionEvent actionEvent) {
        try {
            main.showByCountryClubPage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void byPositionAction(ActionEvent actionEvent) {
        try {
            main.showByPositionPage("Please Enter A Position Name");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void bySalaryAction(ActionEvent actionEvent) {
        try {
        main.showByRangeSalaryPage();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void countrywiseAction(ActionEvent actionEvent) {
        List<Country> list = main.searchPlayer5();
        try {
              main.showCountrywisePlayerCountPage(list);
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
