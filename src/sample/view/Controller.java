package sample.view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Component;
import sample.Controller.ItemController;
import sample.Model.Item_Model;
import sample.Model.Item_fortable;

import java.sql.SQLException;

@Component
public class Controller {
    @Autowired
    private ItemController itemController;
    @FXML private TextField item;
    @FXML private TextField quantity;
    @FXML private TextField price;
    @Autowired
    Item_Model item_model;

    @FXML private TableView<Item_fortable> tableView;
    @FXML private TableColumn<Item_fortable,Integer> tableitemid;
    @FXML private TableColumn<Item_fortable,String> tableitem_name;
    @FXML private TableColumn<Item_fortable,Integer> tablequantity;
    @FXML private TableColumn<Item_fortable,Integer> tableprice;

    public void get_Item(ActionEvent event){
        item_model.setItem(item.getText());
        item_model.setQuality(Integer.parseInt(quantity.getText()));
        item_model.setPrice(Integer.parseInt(price.getText()));
        try {
            itemController.save_Item(item_model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getall_item(){
        try {
            ObservableList<Item_fortable> item_modelObservableList =itemController.getallitem();
            tableitemid.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("itemid"));
            tableitem_name.setCellValueFactory(new PropertyValueFactory<Item_fortable,String>("item"));
            tablequantity.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("quality"));
            tableprice.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("price"));
            tableView.setItems(item_modelObservableList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
