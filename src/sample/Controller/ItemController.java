package sample.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.DB.DBConnection;
import sample.Model.Item_Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
}
