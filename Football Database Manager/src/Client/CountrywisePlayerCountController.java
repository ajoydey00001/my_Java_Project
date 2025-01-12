package Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CountrywisePlayerCountController {
   private Main main;

   @FXML
    private TableView tableView;
   @FXML
    private Button back;

   ObservableList<Country> data;
   private boolean init = true;

   @FXML
    public void backAction(ActionEvent actionEvent) {
       try {
           main.showPlayerSearchingOptionPage();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    private void initializeColumns() {
        TableColumn<Country, String> Col1 = new TableColumn<>("Country's Name");
        Col1.setMinWidth(120);
        Col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Country,Integer> Col2 = new TableColumn<>("PlayerNumber");
        Col2.setMinWidth(120);
        Col2.setCellValueFactory(new PropertyValueFactory<>("count"));

        tableView.getColumns().addAll(Col1,Col2);
    }

    public void load(List<Country> list) {
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
