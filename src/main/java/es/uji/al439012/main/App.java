package es.uji.al439012.main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox layout = new VBox(); // Contenedor principal
        Label label = new Label("Hola mundo!"); // Texto no editable
        Button button = new Button("Un botón :D"); // Un botón, no hace nada
        RadioButton  KMeansBot = new RadioButton("K-Means");
        RadioButton KNNBot = new RadioButton("K-NN");
        KMeansBot.setOnAction(actionEvent -> System.out.println("Pulsaste KMeans negro"));
        KNNBot.setOnAction(actionEvent -> System.out.println("Pulsaste KNN blanquito"));

        ToggleGroup tipoRec = new ToggleGroup();
        KMeansBot.setToggleGroup(tipoRec);
        KNNBot.setToggleGroup(tipoRec);


        layout.getChildren().addAll(label, button, KMeansBot, KNNBot); // Añade elementos al contenedor
        layout.setAlignment(Pos.CENTER); // Centra los elementos
        // Añade el contenedor a la escena, y la escena al escenario
        primaryStage.setScene(new Scene(layout, 200, 100));
        primaryStage.setTitle("JavaFXApp"); // Título de ventana
        primaryStage.show(); // Muestra la ventana
    }
}
