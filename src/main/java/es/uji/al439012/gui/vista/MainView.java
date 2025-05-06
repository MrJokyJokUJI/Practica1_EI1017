// Modifica MainView.java

package es.uji.al439012.gui.vista;

import es.uji.al439012.gui.controlador.Controlador;
import es.uji.al439012.gui.modelo.Modelo;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.List;


public class MainView implements Vista {

    private Controlador controlador;
    private Modelo modelo; // Guarda la referencia al Modelo

    private final HBox root;

    // Variables de instancia para guardar referencias a los paneles
    private final LeftPanel leftPanel;
    private final CenterPanel centerPanel;
    private final RightPanel rightPanel;

    // --- Constructor Modificado para recibir Modelo y Controlador ---
    public MainView(Modelo modelo, Controlador controlador) {
        if (modelo == null) {
            throw new IllegalArgumentException("El modelo no puede ser nulo en MainView");
        }
        // No validamos si el controlador es null aquí si decides setearlo después.
        // if (controlador == null) { ... }

        this.modelo = modelo; // Asigna la referencia al Modelo
        this.controlador = controlador; // Asigna la referencia al Controlador

        root = new HBox(20);
        root.setPadding(new Insets(20, 20, 20, 20));

        // Crear y ASIGNAR a las variables de instancia
        this.leftPanel = new LeftPanel(); // LeftPanel ya no carga solo
        this.centerPanel = new CenterPanel();
        this.rightPanel = new RightPanel();

        // --- Cargar las canciones en el LeftPanel usando el Modelo ---
        // Ahora this.modelo tiene una instancia válida porque la recibimos en el constructor
        List<String> songNames = this.modelo.getAllSongTitles(); // Obtener la lista de canciones del Modelo
        this.leftPanel.setSongsList(songNames); // Pasar la lista de canciones al LeftPanel para que las muestre
        // -------------------------------------------------------------


        // --- Conectar el evento del botón al Controlador (usando la referencia recibida) ---
        Button recommendButton = centerPanel.getBotonRec(); // Obtener el botón del CenterPanel usando el getter
        recommendButton.setOnAction(event -> {
            if (this.controlador != null) { // Usar this.controlador
                this.controlador.botonRecPulsado(); // Llama al método del Controlador
            } else {
                System.err.println("Error: Controlador no establecido en MainView al pulsar botón.");
            }
        });
        // ----------------------------------------------------------------------------------

        // Configurar Hgrow
        HBox.setHgrow(leftPanel.getPanel(), Priority.ALWAYS);
        HBox.setHgrow(centerPanel.getPanel(), Priority.ALWAYS);
        HBox.setHgrow(rightPanel.getPanel(), Priority.ALWAYS);

        // Añadir los paneles al root
        root.getChildren().addAll(leftPanel.getPanel(), centerPanel.getPanel(), rightPanel.getPanel());

        root.getStyleClass().add("root");
    }

    // Elimina el constructor sin argumentos:
     /*
     public MainView() {
        // ... código antiguo ...
     }
     */

    public HBox getView() {
        return root;
    }

    // --- Métodos de la interfaz Vista ---
    @Override
    public String getSelectedSong() {
        ListView<String> songList = leftPanel.getSongList();
        String selectedSongs = songList.getSelectionModel().getSelectedItem();
        return selectedSongs;
    }

    @Override
    public String getRecommendationType() {
        // Usar el getter de CenterPanel para obtener el ComboBox y luego getValue()
        return centerPanel.getOpcionesRec().getValue();
    }

    @Override
    public String getDistanceType() {
        // Usar el getter de CenterPanel para obtener el ComboBox y luego getValue()
        return centerPanel.getOpcionesDis().getValue();
    }

    @Override
    public int getNumberOfRecommendations() {
        // Usar el getter de CenterPanel para obtener el Spinner y luego getValue()
        return centerPanel.getSpinner().getValue();
    }

    @Override
    public void showRecommendations(List<String> recommendations) {
        // Implementa la lógica para mostrar en RightPanel
        StringBuilder sb = new StringBuilder();
        if (recommendations != null && !recommendations.isEmpty()) {
            for (String rec : recommendations) {
                sb.append(rec).append("\n");
            }
        } else {
            sb.append("No se encontraron recomendaciones."); // Mensaje si la lista está vacía o nula
        }
        rightPanel.setRecommendations(sb.toString()); // Asumimos que RightPanel tiene un método setRecommendations
    }

    // Los métodos setControlador y setModelo son necesarios porque la interfaz Vista los requiere.
    // Sin embargo, la inyección principal de dependencias ocurre ahora en el constructor.
    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        // Si el listener del botón se configurara aquí en lugar del constructor, iría aquí.
    }

    @Override
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        // Si la lista de canciones se cargara aquí (ej. por un evento de cambio en el modelo), iría aquí.
    }
    // ------------------------------------------
}