package es.uji.al439012.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("hola mundo");
        Scene scene = new Scene(label, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Mi App JavaFX");
        stage.show();
    }
}


