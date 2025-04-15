package es.uji.al439012.main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {

    private ToggleGroup recommendationGroup;
    private ToggleGroup distanceGroup;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Crear los componentes principales
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.setAlignment(Pos.TOP_LEFT);

        // Sección de tipo de recomendación
        Label recommendationLabel = new Label("Recommendation Type:");
        RadioButton kMeansButton = new RadioButton("k-Means");
        RadioButton knnButton = new RadioButton("k-NN");

        recommendationGroup = new ToggleGroup();
        kMeansButton.setToggleGroup(recommendationGroup);
        knnButton.setToggleGroup(recommendationGroup);
        kMeansButton.setSelected(true);

        HBox recommendationBox = new HBox(10, kMeansButton, knnButton);
        recommendationBox.setAlignment(Pos.BASELINE_LEFT);

        // Sección de tipo de distancia
        Label distanceLabel = new Label("Distance Type:");
        RadioButton euclideanButton = new RadioButton("Euclidean");
        RadioButton manhattanButton = new RadioButton("Manhattan");

        distanceGroup = new ToggleGroup();
        euclideanButton.setToggleGroup(distanceGroup);
        manhattanButton.setToggleGroup(distanceGroup);
        euclideanButton.setSelected(true);

        HBox distanceBox = new HBox(10, euclideanButton, manhattanButton);
        distanceBox.setAlignment(Pos.BASELINE_LEFT);

        // Botón de recomendación
        Button recommendButton = new Button("Recommend");
        recommendButton.setOnAction(e -> handleRecommendation());

        // Área para mostrar resultados
        TextArea resultsArea = new TextArea();
        resultsArea.setEditable(false);
        resultsArea.setPrefHeight(300);

        // Agregar componentes al layout principal
        root.getChildren().addAll(
                recommendationLabel,
                recommendationBox,
                new Separator(),
                distanceLabel,
                distanceBox,
                new Separator(),
                recommendButton,
                new Separator(),
                resultsArea
        );

        // Configurar la escena y mostrar la ventana
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Song Recommender");
        stage.show();
    }

    private void handleRecommendation() {
        // Obtener la selección de algoritmo
        RadioButton selectedRecommendation = (RadioButton) recommendationGroup.getSelectedToggle();
        String algorithm = selectedRecommendation.getText();

        // Obtener la selección de distancia
        RadioButton selectedDistance = (RadioButton) distanceGroup.getSelectedToggle();
        String distance = selectedDistance.getText();

        // Aquí implementarías la lógica de recomendación
        System.out.println("Algorithm: " + algorithm);
        System.out.println("Distance: " + distance);

        // Ejemplo de resultado (deberías reemplazar esto con tu lógica real)
        String result = "Using " + algorithm + " with " + distance + " distance:\n";
        result += "Recommended songs:\n";
        result += "1. Song A\n2. Song B\n3. Song C";

        // Mostrar resultados (necesitarías una referencia al TextArea)
        // resultsArea.setText(result);
    }
}
