// Modifica CenterPanel.java

package es.uji.al439012.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CenterPanel {
    private VBox panel;
    private Button botonRec; // Agrega esta variable de instancia
    private ComboBox<String> opcionesRec; // Agrega variables para los ComboBox y Spinner si el controlador necesita sus valores
    private ComboBox<String> opcionesDis;
    private Spinner<Integer> spinner;


    public CenterPanel() {
        panel = new VBox(15);
        panel.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        panel.setPadding(new Insets(15, 15, 15, 15));

        Label title = new Label("N° DE RECOMENDACIONES");
        title.getStyleClass().add("label");

        GridPane panelOpciones = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        col1.setMinWidth(150);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);

        panelOpciones.getColumnConstraints().addAll(col1, col2);

        Label tipoRec = new Label("Tipo recomendación");
        opcionesRec = new ComboBox<>(); // Inicializa la variable de instancia
        opcionesRec.getItems().addAll("Similitudes", "Genero");

        Label tipoDis = new Label("Tipo distáncia");
        opcionesDis = new ComboBox<>(); // Inicializa la variable de instancia
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

        spinner = new Spinner<>(1, 10, 3); // Inicializa la variable de instancia
        spinner.setEditable(true);

        botonRec = new Button("MOSTRAR RECOMENDACIONES"); // Inicializa la variable de instancia

        panel.getChildren().addAll(title, spinner, panelOpciones, botonRec);
    }

    public VBox getPanel() {
        return panel;
    }

    // --- Métodos para obtener los controles ---
    public Button getBotonRec() {
        return botonRec;
    }

    public ComboBox<String> getOpcionesRec() {
        return opcionesRec;
    }

    public ComboBox<String> getOpcionesDis() {
        return opcionesDis;
    }

    public Spinner<Integer> getSpinner() {
        return spinner;
    }

}