package sample.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.Controller.ItemController;
import sample.view.Controller;

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
//        Controller controller = loader.getController();
        primaryStage.setTitle("Hello World");
        Scene scene=new Scene(root, 925, 450);
        primaryStage.setScene(scene);
        primaryStage.show();

        Controller controller=ctx.getBean(Controller.class);
        controller.setAnnotationConfigApplicationContext(ctx);
        controller.setScene(scene);
        controller.setStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);


    }
}


