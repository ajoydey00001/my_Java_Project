package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.Player;
import java.util.List;

public class ByCountryClubController {
   private Main main;

   @FXML
    private TextField countryName;
   @FXML
    private Button reset;
   @FXML
    private Button enter;

    @FXML
    public void resetAction(ActionEvent actionEvent) {
        countryName.setText(null);
    }
    @FXML
    public void enterAction(ActionEvent actionEvent) {
      String c = countryName.getText();
        List<Player> list = main.searchPlayer2(c);
        if(list.isEmpty()) {
            try {
                main.showPlayerSearchingAlertPage("No Such Player With This Country Name");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                main.showFromPlayerListPage(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

}
