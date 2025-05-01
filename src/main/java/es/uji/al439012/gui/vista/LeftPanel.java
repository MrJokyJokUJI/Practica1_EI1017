// Modifica LeftPanel.java

package es.uji.al439012.gui.vista;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.List; // Importa List
// Eliminamos las importaciones de BufferedReader, FileReader, IOException

public class LeftPanel {
    private final VBox panel;
    private final ListView<String> songList;

    public LeftPanel() {
        panel = new VBox(15);
        panel.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        panel.setPadding(new javafx.geometry.Insets(15));

        Label titleLabel = new Label("SELECCIONA TUS FAVORITAS");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.getStyleClass().add("label");

        songList = new ListView<>();
        // Eliminamos la llamada a loadSongsFromCSV(songList);
        songList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox.setVgrow(songList, Priority.ALWAYS);
        songList.setPrefWidth(350);

        panel.getChildren().addAll(titleLabel, songList);
    }

    // Eliminamos el método private void loadSongsFromCSV(...)

    public VBox getPanel() {
        return panel;
    }

    public ListView<String> getSongList() {
        return songList;
    }

    // --- Método para establecer la lista de canciones (llamado desde MainView) ---
    public void setSongsList(List<String> songs) {
        songList.getItems().clear(); // Limpiar la lista actual por si acaso
        if (songs != null) {
            songList.getItems().addAll(songs); // Agregar las nuevas canciones a la ListView
        }
    }
    // ----------------------------------------------------------------------------
}