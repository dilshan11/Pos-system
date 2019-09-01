package sample.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.Controller.ItemController;
import sample.Model.Item_Model;

import java.sql.SQLException;

@Component
public class Controller {
    @Autowired
    private ItemController itemController;
    @FXML
    private TextField item;
    @FXML
    private TextField quantity;
    @FXML
    private TextField price;
    @Autowired
    Item_Model item_model;
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

}
