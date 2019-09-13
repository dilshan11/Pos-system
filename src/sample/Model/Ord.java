package sample.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ord")
public class Ord {

    @Id
    @Column(name = "order_id")
    int orderid;

    @Column(name = "date")
    String date;

    @OneToMany(mappedBy = "ord")
    List<Order_item> order_itemList=new ArrayList<>();

    public Ord() {
    }

    public Ord(String date) {
        this.date = date;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Order_item> getOrder_itemList() {
        return order_itemList;
    }

    public void setOrder_itemList(List<Order_item> order_itemList) {
        this.order_itemList = order_itemList;
    }

    @Override
    public String toString() {
        return "Ord{" +
                "orderid=" + orderid +
                ", date='" + date + '\'' +
                ", order_itemList=" + order_itemList +
                '}';
    }
}
