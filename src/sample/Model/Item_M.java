package sample.Model;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item_M {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "itemid")
    int itemid;
    @Column(name = "item_name")
    String item;
    @Column(name = "quantity")
    int quality;
    @Column(name = "price")
    float price;

    public Item_M() {
    }

    public Item_M(String item, int quality, float price) {
        this.item = item;
        this.quality = quality;
        this.price = price;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item_M{" +
                "itemid=" + itemid +
                ", item='" + item + '\'' +
                ", quality=" + quality +
                ", price=" + price +
                '}';
    }
}
