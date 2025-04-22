package es.uji.al439012.gui.vista;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class LeftPanel {
    private final VBox panel;

    public LeftPanel() {
        panel = new VBox(15);
        panel.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        panel.setPadding(new javafx.geometry.Insets(15));

        Label titleLabel = new Label("SELECCIONA TUS FAVORITAS");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.getStyleClass().add("label");

        ListView<String> songList = new ListView<>();
        songList.getItems().addAll(
                "Dance The Night - Dua Lipa",
                "Flowers - Miley Cyrus",
                "Blinding Lights - The Weeknd",
                "Levitating - Dua Lipa",
                "Save Your Tears - The Weeknd"
        );
        songList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox.setVgrow(songList, Priority.ALWAYS);
        songList.setPrefWidth(350);

        panel.getChildren().addAll(titleLabel, songList);
    }

    public VBox getPanel() {
        return panel;
    }
}