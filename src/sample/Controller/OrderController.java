package sample.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.Model.Item_M;
import sample.Model.Ord;
import sample.Model.Order_item;

import java.util.List;

@Component
public class OrderController {
    @Autowired
    SessionFactory sessionFactory;

    public int get_orderid(){

        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            List<Ord> orderList =session.createNativeQuery("select * from ord where order_id=( select Max(order_id) from ord)",Ord.class).list();
            session.getTransaction().commit();
            System.out.println(orderList.get(0).getOrderid()+1);
            return orderList.get(0).getOrderid();
        }
        catch (Exception e) {
            if (transaction != null) {
                System.out.println(e);
                //transaction.rollback();
            }
        }
        finally {
            session.close();
        }
        return 0;
    }

    public void save_place_order(Order_item order_item){
        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
             session.save(order_item);
            session.getTransaction().commit();

        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
    }
    public int get_getitemid(int id){

        Session session=sessionFactory.getCurrentSession();
        Transaction transaction=null;
        try {
            transaction=session.beginTransaction();
            Item_M item_m=session.get(Item_M.class,id);
            session.getTransaction().commit();
            System.out.println(item_m.getQuality());
            return item_m.getQuality();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
        return 0;
    }
}
