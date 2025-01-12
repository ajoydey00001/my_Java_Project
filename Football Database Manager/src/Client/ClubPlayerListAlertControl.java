package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClubPlayerListAlertControl {
    private Main main;
    @FXML
    private Label message;
    @FXML
    private Button button;

    public void init(String msg) {
        message.setText(msg);
    }

    @FXML
    void buttonAction(ActionEvent event) {
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
