package sample.Model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.stereotype.Component;

@Component
public class Item_fortable {
    SimpleIntegerProperty itemid;
    SimpleStringProperty item;
    SimpleIntegerProperty quality;
    SimpleFloatProperty price;
    SimpleFloatProperty total;
    public Item_fortable() {
    }

    public Item_fortable(int itemid, String item, int quality, float price) {
        this.itemid =new SimpleIntegerProperty(itemid);
        this.item = new SimpleStringProperty(item);
        this.quality =new SimpleIntegerProperty(quality);
        this.price = new SimpleFloatProperty(price);
    }

    public Item_fortable( int itemid, String item, int quality, float price,float total) {
        this.itemid =new SimpleIntegerProperty(itemid);
        this.item = new SimpleStringProperty(item);
        this.quality =new SimpleIntegerProperty(quality);
        this.price = new SimpleFloatProperty(price);
        this.total=new SimpleFloatProperty(total);
    }

    public int getItemid() {
        return itemid.get();
    }


    public String getItem() {
        return item.get();
    }



    public int getQuality() {
        return quality.get();
    }


    public float getPrice() {
        return price.get();
    }

    public float getTotal() {
        return total.get();
    }

    public SimpleFloatProperty totalProperty() {
        return total;
    }

    public void setTotal(float total) {
        this.total.set(total);
    }
}
