package sample.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.Controller.ItemController;
import sample.Model.Item_Model;
import sample.view.Controller;

import java.lang.annotation.Annotation;

public class
Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/sample.fxml"));
        loader.setControllerFactory(ctx::getBean);

        Parent root = loader.load();
        Controller controller = loader.getController();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 925, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}


