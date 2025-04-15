package es.uji.al439012.main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch( args );
    }

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");;
        String javafxVersion = System.getProperty("javafx.version");;

        Label label1 = new Label("Si lees esto eres gay");
        VBox vbox = new VBox(label1);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
}


