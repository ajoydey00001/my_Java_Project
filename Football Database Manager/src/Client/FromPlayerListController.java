package Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import util.Player;

import java.util.List;

public class FromPlayerListController {
   private Main main;

   @FXML
    private TableView tableView;
   @FXML
    private Button back;

   ObservableList<Player> data;
    private boolean init = true;

   @FXML
    void backAction(ActionEvent actionEvent) {
       try {
           main.showPlayerSearchingOptionPage();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    private void initializeColumns() {
        TableColumn<Player, String> Col1 = new TableColumn<>("Name");
        Col1.setMinWidth(140);
        Col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Player, String> Col2 = new TableColumn<>("Country");
        Col2.setMinWidth(80);
        Col2.setCellValueFactory(new PropertyValueFactory<>("country"));
        TableColumn<Player, Integer> Col3 = new TableColumn<>("Age");
        Col3.setMinWidth(80);
        Col3.setCellValueFactory(new PropertyValueFactory<>("age"));
        TableColumn<Player, Double> Col4 = new TableColumn<>("Height");
        Col4.setMinWidth(80);
        Col4.setCellValueFactory(new PropertyValueFactory<>("height"));
        TableColumn<Player, String> Col5 = new TableColumn<>("Club");
        Col5.setMinWidth(80);
        Col5.setCellValueFactory(new PropertyValueFactory<>("club"));
        TableColumn<Player, String> Col6 = new TableColumn<>("Position");
        Col6.setMinWidth(80);
        Col6.setCellValueFactory(new PropertyValueFactory<>("position"));
        TableColumn<Player, Integer> Col7 = new TableColumn<>("Number");
        Col7.setMinWidth(80);
        Col7.setCellValueFactory(new PropertyValueFactory<>("number"));
        TableColumn<Player, Double> Col8 = new TableColumn<>("Weekly Salary");
        Col8.setMinWidth(80);
        Col8.setCellValueFactory(new PropertyValueFactory<>("weeklysalary"));

        tableView.getColumns().addAll(Col1,Col2,Col3,Col4,Col5,Col6,Col7,Col8);
    }

    public void load(List<Player> list) {

        if (init) {
            initializeColumns();
            init = false;
        }

        data = FXCollections.observableArrayList(list);
        tableView.setItems(data);
    }

    void setMain(Main main) {
        this.main = main;
    }



}
