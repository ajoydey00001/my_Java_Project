package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Player;
import java.util.List;

public class ByPositionController {
    private Main main;

    @FXML
    private TextField name;
    @FXML
    private Button reset;
    @FXML
    private Button enter;
    @FXML
    private Label message;

    public void init(String msg) {
        message.setText(msg);
    }

    @FXML
    public void resetAction(ActionEvent actionEvent) {
        name.setText(null);
    }
    @FXML
    public void enterAction(ActionEvent actionEvent) {
        String s = name.getText();
        List<Player> list = main.searchPlayer3(s);
        if(list.isEmpty()) {
            try {
                main.showPlayerSearchingAlertPage("No Such Player With This Position");
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
