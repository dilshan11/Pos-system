package sample.main;

import javafx.scene.Scene;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import sample.Model.Item_M;

import java.io.File;


@org.springframework.context.annotation.Configuration
@ComponentScan("sample")
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory(){
        SessionFactory sessionFactory=new Configuration().configure("sample/resources/hibernate.cgx.xml")
                .addAnnotatedClass(Item_M.class)
                .buildSessionFactory();
        return sessionFactory;
    }



}
