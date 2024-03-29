package sample.view;

import com.mysql.cj.MysqlType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import sample.Controller.ItemController;
import sample.Controller.OrderController;
import sample.Controller.OrderDetails;
import sample.Model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Controller {
    @Autowired
    ItemController itemController;
    @FXML  TextField item;
    @FXML  TextField quantity;
    @FXML  TextField price;
    @FXML AnchorPane anchorPane;

    @FXML  TableView<Item_fortable> tableView;
    @FXML  TableColumn<Item_fortable,Integer> tableitemid;
    @FXML  TableColumn<Item_fortable,String> tableitem_name;
    @FXML  TableColumn<Item_fortable,Integer> tablequantity;
    @FXML  TableColumn<Item_fortable,Float> tableprice;




    AnnotationConfigApplicationContext annotationConfigApplicationContext;
    Stage stage;
    Scene scene;

    public Controller() {

    }

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
    public void scenechnageto_orderDetails(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("orderDetails.fxml"));
            loader.setControllerFactory(annotationConfigApplicationContext::getBean);
            Parent root = loader.load();
            Scene scene=new Scene(root, 925, 500);
            System.out.println(stage);
            stage.setScene(scene);
            stage.show();
            getall_order();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void unsuccesfull(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setContentText("field is empty");
        alert.showAndWait();
    }

    public void scenechnageto_order(){
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
            loader.setControllerFactory(annotationConfigApplicationContext::getBean);
            Parent root = loader.load();
            Scene scene=new Scene(root, 925, 600);

            stage.setScene(scene);
            stage.show();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            date1.setText(formatter.format(date));

             this.item_modelObservableList2 = FXCollections.observableArrayList();


            tableitemid2.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("itemid"));
            tableitem_name2.setCellValueFactory(new PropertyValueFactory<Item_fortable,String>("item"));
            tablequantity2.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("quality"));
            tableprice2.setCellValueFactory(new PropertyValueFactory<Item_fortable,Float>("price"));
            total2.setCellValueFactory(new PropertyValueFactory<Item_fortable,Float>("total"));
            tableView2.setItems(item_modelObservableList2);

           set_orderid();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getall_item(){

            ObservableList<Item_fortable> item_modelObservableList =itemController.getallitem();
            tableitemid.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("itemid"));
            tableitem_name.setCellValueFactory(new PropertyValueFactory<Item_fortable,String>("item"));
            tablequantity.setCellValueFactory(new PropertyValueFactory<Item_fortable,Integer>("quality"));
            tableprice.setCellValueFactory(new PropertyValueFactory<Item_fortable,Float>("price"));
            tableView.setItems(item_modelObservableList);
    }
    public boolean checking_field(){
        if(item.getText().isEmpty() || quantity.getText().isEmpty() || price.getText().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
        public void save_item() {
            try {
                Item_M item_m = new Item_M(item.getText(), Integer.parseInt(quantity.getText()), Float.parseFloat(price.getText()));
                int a = itemController.save_item(item_m);
                if (a == 1) {
                    item.setText("");
                    quantity.setText("");
                    price.setText("");
                }
            }catch (Exception e){
                unsuccesfull();
            }
        }
    Item_M item_m;
        public void search_item() {
            try {
                item_m = itemController.serach_item(item.getText());
                item.setText(item_m.getItem());
                quantity.setText(Integer.toString(item_m.getQuality()));
                price.setText(Float.toString(item_m.getPrice()));
            }catch (Exception e){
                unsuccesfull();
            }
        }
        public void update_item() {
            try {
                Item_M item_m = new Item_M(item.getText(), Integer.parseInt(quantity.getText()), Float.parseFloat(price.getText()));
                item_m.setItemid(this.item_m.getItemid());
                itemController.update_item(item_m);
                item.setText("");
                quantity.setText("");
                price.setText("");
            }catch (Exception e){
                unsuccesfull();
            }
        }
        public void delete_item() {
            try {
                item_m = itemController.serach_item(item.getText());
                item.setText(item_m.getItem());
                itemController.delete_item(item_m);
                item.setText("");
                quantity.setText("");
                price.setText("");
            }catch (Exception e){
                unsuccesfull();
            }
        }
    @FXML TextField item2;
    @FXML TextField code2;
    @FXML Label unitprice2;
    @FXML Label qtyonhand2;
    @FXML TextField saveqty;
    @FXML Label oreder2;

    @FXML  TableView<Item_fortable> tableView2;
    @FXML  TableColumn<Item_fortable,Integer> tableitemid2;
    @FXML  TableColumn<Item_fortable,String> tableitem_name2;
    @FXML  TableColumn<Item_fortable,Integer> tablequantity2;
    @FXML  TableColumn<Item_fortable,Float> tableprice2;
    @FXML  TableColumn<Item_fortable,Float> total2;
    @FXML Label date1;
    @Autowired
    OrderController orderController;

    ObservableList<Item_fortable> item_modelObservableList2;
    public void search_item2() {
        try {
            item_m = itemController.serach_item(this.item2.getText());
            code2.setText(Integer.toString(item_m.getItemid()));
            qtyonhand2.setText(Integer.toString(item_m.getQuality()));
            unitprice2.setText(Float.toString(item_m.getPrice()));
        }catch (Exception e){
            unsuccesfull();
        }
    }
    public void additem_to_table2() {
        try {
            // System.out.println(Integer.parseInt(saveqty.getText())* Float.parseFloat(unitprice2.getText()));
            float total = Integer.parseInt(saveqty.getText()) * Float.parseFloat(unitprice2.getText());
            Item_fortable item_fortable2 = new Item_fortable(Integer.parseInt(code2.getText()), item2.getText(), Integer.parseInt(saveqty.getText()), Float.parseFloat(unitprice2.getText()), total);
            this.item_modelObservableList2.add(item_fortable2);
        }catch (Exception e){
            unsuccesfull();
        }
    }

    public void set_orderid(){
        try {
            if (oreder2.getText() != "1") {
                System.out.println(orderController.get_orderid());
                oreder2.setText(Integer.toString(orderController.get_orderid() + 1));
            }
        }catch (Exception e){
            unsuccesfull();
        }

    }
    public void save_place_order() {
        try {
            Ord ord = new Ord(date1.getText());
            ord.setOrderid(Integer.parseInt(oreder2.getText()));
            for (Item_fortable item_fortable : item_modelObservableList2) {
                int quantity = orderController.get_getitemid(Integer.parseInt(code2.getText())) - (int) item_fortable.getQuality();

                Item_M item_m = new Item_M((String) item_fortable.getItem(), quantity, (Float) item_fortable.getPrice());
                item_m.setItemid((int) item_fortable.getItemid());
                Order_item order_item = new Order_item((int) item_fortable.getQuality(), (Float) item_fortable.getPrice(), (float) item_fortable.getTotal());
                order_item.setOrder(ord);
                order_item.setItem_m(item_m);
                System.out.println(ord);
                System.out.println(item_m);
                orderController.save_place_order(order_item);
            }
            oreder2.setText(Integer.toString(orderController.get_orderid() + 1));
        }catch (Exception e){
            unsuccesfull();
        }
    }

    @Autowired
    OrderDetails orderDetails;

    @FXML  TableView<Order_forta> tableView3;
    @FXML  TableColumn<Order_forta,Integer> orderid3;
    @FXML  TableColumn<Order_forta,String> orderdate3;

    public void getall_order(){
        ObservableList<Order_forta> order_fortaList = orderDetails.getall_order();
        orderid3.setCellValueFactory(new PropertyValueFactory<Order_forta,Integer>("orderid"));
        orderdate3.setCellValueFactory(new PropertyValueFactory<Order_forta,String>("date"));
        tableView3.setItems(order_fortaList);

    }

    @FXML
    private void handleRowSelect() {
        Order_forta order_forta = tableView3.getSelectionModel().getSelectedItem();
        System.out.println(order_forta);
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
