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

    public Item_fortable() {
    }

    public Item_fortable(int itemid, String item, int quality, float price) {
        this.itemid =new SimpleIntegerProperty(itemid);
        this.item = new SimpleStringProperty(item);
        this.quality =new SimpleIntegerProperty(quality);
        this.price = new SimpleFloatProperty(price);
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


}
