package sample.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import sample.Controller.ItemController;

@Component
public class Item_Model {
    int itemid;
    String item;
    int quality;
    float price;

    @Autowired
    ItemController itemController;


    public Item_Model() {

    }

    public Item_Model(String item, int quality, float price) {
        this.item = item;
        this.quality = quality;
        this.price = price;
    }

    public Item_Model(int itemid, String item, int quality, float price) {
        this.itemid = itemid;
        this.item = item;
        this.quality = quality;
        this.price = price;
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

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Override
    public String toString() {
        return "Item_Model{" +
                "item='" + item + '\'' +
                ", quality=" + quality +
                ", price=" + price +
                '}';
    }
}
