package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private AnchorPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Predictor");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
//        loadViews();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
