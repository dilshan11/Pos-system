package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Order_forta {
    SimpleIntegerProperty orderid;
    SimpleStringProperty date;

    public Order_forta() {
    }

    public Order_forta(int orderid, String date) {
        this.orderid = new SimpleIntegerProperty(orderid);
        this.date = new SimpleStringProperty(date);
    }

    public int getOrderid() {
        return orderid.get();
    }

    public SimpleIntegerProperty orderidProperty() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid.set(orderid);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    @Override
    public String toString() {
        return "Order_forta{" +
                "orderid=" + orderid +
                ", date=" + date +
                '}';
    }
}
