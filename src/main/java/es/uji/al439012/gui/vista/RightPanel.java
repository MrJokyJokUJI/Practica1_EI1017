package es.uji.al439012.gui.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class RightPanel {
    private final VBox panel;

    public RightPanel() {
        panel = new VBox(15);
        panel.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        panel.setPadding(new Insets(15,15,15,15));

        Label title = new Label("RECOMENDACIONES");
        title.getStyleClass().add("label");

        TextArea recommendationsArea = new TextArea();
        recommendationsArea.getStyleClass().add("recommendations-area");
        recommendationsArea.setEditable(false);
        recommendationsArea.setPrefHeight(300);
        recommendationsArea.setPromptText("Tus recomendaciones aparecerán aquí...");

        panel.getChildren().addAll(title, recommendationsArea);
    }

    public VBox getPanel() {
        return panel;
    }
}