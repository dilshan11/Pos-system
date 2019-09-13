package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.Model.Item_fortable;
import sample.Model.Ord;
import sample.Model.Order_forta;
import sample.Model.Order_item;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDetails {
    @Autowired
    SessionFactory sessionFactory;

    public  ObservableList<Order_forta>getall_order(){
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        List<Order_forta> order_fortaList=new ArrayList<>();
        try {
            transaction=session.beginTransaction();
            List<Ord> ordList =session.createCriteria(Ord.class).list();
            session.getTransaction().commit();
            for(Ord ord:ordList){
                Order_forta order_forta=new Order_forta(ord.getOrderid(),ord.getDate());
                order_fortaList.add(order_forta);
            }
            ObservableList<Order_forta> item_modelObservableList = FXCollections.observableArrayList(order_fortaList);
            return item_modelObservableList;

        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
        return null;
    }
}
