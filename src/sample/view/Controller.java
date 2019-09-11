package sample.view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import sample.Controller.ItemController;
import sample.Model.Item_M;
import sample.Model.Item_fortable;

import java.io.IOException;

@Component
public class Controller {
    @Autowired
    ItemController itemController;
    @FXML  TextField item;
    @FXML  TextField quantity;
    @FXML  TextField price;
    @FXML
    AnchorPane anchorPane;
    Scene scene;

    @FXML  TableView<Item_fortable> tableView;
    @FXML  TableColumn<Item_fortable,Integer> tableitemid;
    @FXML  TableColumn<Item_fortable,String> tableitem_name;
    @FXML  TableColumn<Item_fortable,Integer> tablequantity;
    @FXML  TableColumn<Item_fortable,Float> tableprice;

    AnnotationConfigApplicationContext annotationConfigApplicationContext;
    Stage stage;

    public void backto_main(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            loader.setControllerFactory(annotationConfigApplicationContext::getBean);
            Parent root = loader.load();
            Scene scene=new Scene(root, 925, 400);
            System.out.println(stage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void scenechnageto_item(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("frist.fxml"));
            loader.setControllerFactory(annotationConfigApplicationContext::getBean);
            Parent root = loader.load();
            Scene scene=new Scene(root, 925, 400);
            System.out.println(stage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void scenechnageto_order(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
            loader.setControllerFactory(annotationConfigApplicationContext::getBean);
            Parent root = loader.load();
            Scene scene=new Scene(root, 925, 400);
            System.out.println(stage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getall_item(){
        System.out.println(itemController);
            ObservableList<Item_fortable> item_modelObservableList =itemController.getallitem();
            tableitemid.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("itemid"));
            tableitem_name.setCellValueFactory(new PropertyValueFactory<Item_fortable,String>("item"));
            tablequantity.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("quality"));
            tableprice.setCellValueFactory(new PropertyValueFactory<Item_fortable,Float>("price"));
            tableView.setItems(item_modelObservableList);
    }
        public void save_item(){
            Item_M item_m=new Item_M(item.getText(),Integer.parseInt(quantity.getText()),Float.parseFloat(price.getText()));

            int a=itemController.save_item(item_m);
            if(a==1){
                item.setText("");
                quantity.setText("");
                price.setText("");
            }

        }
    Item_M item_m;
        public void search_item(){
             item_m=itemController.serach_item(item.getText());
            item.setText(item_m.getItem());
            quantity.setText(Integer.toString(item_m.getQuality()));
            price.setText(Float.toString(item_m.getPrice()));
        }
        public void update_item(){
            Item_M item_m=new Item_M(item.getText(),Integer.parseInt(quantity.getText()),Float.parseFloat(price.getText()));
            item_m.setItemid(this.item_m.getItemid());
            itemController.update_item(item_m);
            item.setText("");
            quantity.setText("");
            price.setText("");
        }
        public void delete_item(){
            item_m=itemController.serach_item(item.getText());
            item.setText(item_m.getItem());
            itemController.delete_item(item_m);
            item.setText("");
            quantity.setText("");
            price.setText("");
        }









    public AnnotationConfigApplicationContext getAnnotationConfigApplicationContext() {
        return annotationConfigApplicationContext;
    }

    public void setAnnotationConfigApplicationContext(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
        this.annotationConfigApplicationContext = annotationConfigApplicationContext;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
