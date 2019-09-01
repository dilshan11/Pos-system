package sample.DB;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBConnection {
    private Connection connection;
     DBConnection(){
         try {
             Class.forName("com.mysql.jdbc.Driver");
             connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/market?autoReconnect=true&useSSL=false","root","nanayakkara");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
        return "DBConnection{" +
                "connection=" + connection +
                '}';
    }
}
