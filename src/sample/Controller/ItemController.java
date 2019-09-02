package sample.Controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.DB.DBConnection;
import sample.Model.Item_Model;
import sample.Model.Item_fortable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ItemController {

    public ItemController() {
    }

    @Autowired
    private DBConnection dbConnection;
    public void save_Item(Item_Model item_model) throws SQLException {
        Connection connection=dbConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into item(item_name,quantity,price) values(?,?,?)");
        preparedStatement.setObject(1,item_model.getItem());
        preparedStatement.setObject(2,item_model.getQuality());
        preparedStatement.setObject(3,item_model.getPrice());
        preparedStatement.executeUpdate();
    }
    public ObservableList<Item_fortable> getallitem() throws SQLException {
        Connection connection=dbConnection.getConnection();
        String sql="select * from item";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        List<Item_fortable> item_modelList=new ArrayList<>();
        while(resultSet.next()){
            int itemid=resultSet.getInt("itemid");
            String item_name=resultSet.getString("item_name");
            int quantity=resultSet.getInt("quantity");
            int price=resultSet.getInt("price");
            Item_fortable item_fortable=new Item_fortable(itemid,item_name,quantity,price);
            item_modelList.add(item_fortable);
        }
            ObservableList<Item_fortable> item_modelObservableList= FXCollections.observableArrayList(item_modelList);

            return item_modelObservableList;
    }
}
