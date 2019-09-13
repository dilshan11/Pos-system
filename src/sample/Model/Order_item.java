package sample.Model;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class Order_item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int order_itemid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    Ord ord;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    Item_M item_m;

    @Column(name = "quantity")
    int quantity;
    @Column(name = "unit_price")
    float unitpric;
    @Column(name = "total")
    float total;

    public Order_item() {
    }

    public Order_item(int quantity, float unitpric, float total) {
        this.quantity = quantity;
        this.unitpric = unitpric;
        this.total = total;
    }

    public int getOrder_itemid() {
        return order_itemid;
    }

    public void setOrder_itemid(int order_itemid) {
        this.order_itemid = order_itemid;
    }

    public Ord getOrder() {
        return ord;
    }

    public void setOrder(Ord ord) {
        this.ord = ord;
    }

    public Item_M getItem_m() {
        return item_m;
    }

    public void setItem_m(Item_M item_m) {
        this.item_m = item_m;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitpric() {
        return unitpric;
    }

    public void setUnitpric(float unitpric) {
        this.unitpric = unitpric;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order_item{" +
                "order_itemid=" + order_itemid +
                ", ord1=" + ord +
                ", item_m=" + item_m +
                ", quantity=" + quantity +
                ", unitpric=" + unitpric +
                ", total=" + total +
                '}';
    }
}
