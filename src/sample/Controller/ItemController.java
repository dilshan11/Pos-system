package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Component;
import sample.Model.Item_M;
import sample.Model.Item_fortable;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemController {
    @Autowired
    SessionFactory sessionFactory;
    public ItemController() {
    }

    public void succesfullmessage(String title,String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
    public void unsuccesfull(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setContentText("Ooops, there was an error!");
        alert.showAndWait();
    }

    public int save_item(Item_M item_m){

        int a=0;
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            session.save(item_m);
            session.getTransaction().commit();
            succesfullmessage("item Dialoge","succefullay added");
            a= 1;
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                unsuccesfull();
                a= 0;
            }
        }
        finally {
            session.close();
        }
        return a;
    }
    public ObservableList<Item_fortable> getallitem(){
        Session session=sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            List<Item_M> item_mList = session.createNativeQuery("select * from item", Item_M.class).list();


            List<Item_fortable> item_modelList=new ArrayList<>();
            for(Item_M item_m:item_mList) {
                Item_fortable item_fortable = new Item_fortable(item_m.getItemid(), item_m.getItem(), item_m.getQuality(), item_m.getPrice());
                item_modelList.add(item_fortable);
            }
                ObservableList<Item_fortable> item_modelObservableList = FXCollections.observableArrayList(item_modelList);
                session.getTransaction().commit();
                return item_modelObservableList;

        }finally {

        }
    }
    public Item_M serach_item(String findme){
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            List<Item_M> item_mList = session.createNativeQuery("select * from item where item_name='"+findme+"'", Item_M.class).list();
            if(item_mList.size()>0){
                return item_mList.get(0);
            }else{
                return null;
            }
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                unsuccesfull();

            }
        }finally {
            session.close();

        }
        return null;

    }
    public void update_item(Item_M item_m){
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        System.out.println("update item set price="+item_m.getPrice()+" ,quantity="+item_m.getQuality()+" ,item_name='"+item_m.getItem()+"'  where item_name='"+item_m.getItemid()+"'");
        try{
            transaction=session.beginTransaction();
            session.createNativeQuery("update item set price="+item_m.getPrice()+" ,quantity="+item_m.getQuality()+" ,item_name='"+item_m.getItem()+"'  where itemid="+item_m.getItemid()).executeUpdate();

            succesfullmessage("update item","succefully updated");
                transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                unsuccesfull();

            }
        }finally {
            session.close();

        }


    }
    public void delete_item(Item_M item_m){

        int a=0;
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            session.delete(item_m);
            session.getTransaction().commit();
            succesfullmessage("item Dialoge","succefullay deleted");
            a= 1;
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                unsuccesfull();
                a= 0;
            }
        }
        finally {
            session.close();
        }

    }

}
