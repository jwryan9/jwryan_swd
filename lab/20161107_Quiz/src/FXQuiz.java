/**
 * Created by jasonryan on 11/7/16.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class FXQuiz extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("MyGui.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("My First FX GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
