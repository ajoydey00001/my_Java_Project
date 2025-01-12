package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class SellingController {
   private Main main;

   @FXML
    private TextField name;
   @FXML
    private TextField money;
   @FXML
    private Button reset;
   @FXML
    private Button enter;

    @FXML
    public void enterAction(ActionEvent actionEvent) {
       String s = name.getText();
       String p = money.getText();
       main.selling(s,Double.parseDouble(p));
        try {
            main.showMainMenuPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void resetAction(ActionEvent actionEvent) {
        name.setText(null);
        money.setText(null);
    }
    void setMain(Main main) {
        this.main = main;
    }
}
