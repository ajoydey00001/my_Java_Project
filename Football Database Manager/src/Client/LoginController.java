package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    private Main main;

    @FXML
    private TextField name;
    @FXML
    private Button reset;
    @FXML
    private Button enter;

    @FXML
    public void resetAction(ActionEvent actionEvent) {
        name.setText(null);
    }

    @FXML
    public void enterAction(ActionEvent actionEvent) {
      String s = name.getText();
      try {
          main.Initialize(s);
      } catch (Exception e) {
          System.out.println(e);
      }
    }
    void setMain(Main main) {
        this.main = main;
    }
}
