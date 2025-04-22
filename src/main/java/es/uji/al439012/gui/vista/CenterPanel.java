package es.uji.al439012.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.*;

public class CenterPanel {
    private final VBox panel;

    public CenterPanel() {
        panel = new VBox(15);
        panel.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        panel.setPadding(new Insets(15, 15, 15, 15));

        Label title = new Label("N° DE RECOMENDACIONES");
        title.getStyleClass().add("label");

        GridPane panelOpciones = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        col1.setMinWidth(150); // o ajusta según el tamaño del texto

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);

        panelOpciones.getColumnConstraints().addAll(col1, col2);


        Label tipoRec = new Label("Tipo recomendación");
        ComboBox opcionesRec = new ComboBox<>();
        opcionesRec.getItems().addAll("Similitudes", "Genero");

        Label tipoDis = new Label("Tipo distáncia");
        ComboBox opcionesDis = new ComboBox();
        opcionesDis.getItems().addAll("Euclediana", "Manhattan");

        tipoRec.setMaxWidth(Double.MAX_VALUE);
        tipoDis.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(tipoRec, Priority.ALWAYS);
        GridPane.setHgrow(tipoDis, Priority.ALWAYS);


        panelOpciones.add(tipoRec, 0, 0);
        panelOpciones.add(opcionesRec, 1, 0);
        panelOpciones.add(tipoDis, 0, 1);
        panelOpciones.add(opcionesDis, 1, 1);
        panelOpciones.setHgap(10);
        panelOpciones.setVgap(10);


        Spinner<Integer> spinner = new Spinner<>(1, 10, 3);
        spinner.setEditable(true);


        Button recommendButton = new Button("MOSTRAR RECOMENDACIONES");

        panel.getChildren().addAll(title, spinner, panelOpciones, recommendButton);
    }

    public VBox getPanel() {
        return panel;
    }
}