package es.uji.al439012.gui.vista;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        loadSongsFromCSV(songList);
        songList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox.setVgrow(songList, Priority.ALWAYS);
        songList.setPrefWidth(350);

        panel.getChildren().addAll(titleLabel, songList);
    }

    private void loadSongsFromCSV(ListView<String> songList) {
        String path = "C:/Users/Vicent/IdeaProjects/Practica1_EI1017/src/main/resources/recommender/songs_test_names.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                songList.getItems().add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error cargando canciones: " + e.getMessage());
        }
    }

    public VBox getPanel() {
        return panel;
    }
}