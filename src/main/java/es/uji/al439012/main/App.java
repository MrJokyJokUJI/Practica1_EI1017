package es.uji.al439012.main;

import es.uji.al439012.gui.controlador.Controlador;
import es.uji.al439012.gui.controlador.ControladorRec;
import es.uji.al439012.gui.modelo.Modelo;
import es.uji.al439012.gui.modelo.ModeloRec; // Asegúrate de que esta importación es correcta
import es.uji.al439012.gui.vista.ImplementaciónVista; // Asegúrate de esta importación
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 1. Crear el Modelo
        Modelo modelo = new ModeloRec();

        // 2. Crear el Controlador
        // Usando el constructor sin argumentos
        Controlador controlador = new ControladorRec();

        // 3. Crear la Vista, pasando el Modelo y el Controlador
        // ¡IMPORTANTE! Usar el constructor que recibe Modelo y Controlador
        // Ahora MainView requiere el Modelo y el Controlador en su constructor
        ImplementaciónVista vistaPrincipal = new ImplementaciónVista(modelo, controlador); // Pasa modelo y controlador

        // 4. Conectar el Controlador con la Vista y el Modelo
        // setVista y setModelo en el controlador para que tenga referencias
        controlador.setVista(vistaPrincipal);
        controlador.setModelo(modelo); // Asegúrate del nombre del método (seModelo vs setModelo)

        // Nota: MainView ya tiene las referencias al modelo y controlador gracias a su constructor.
        // Los métodos setVista/setModelo en la Vista ahora son menos críticos para la configuración inicial
        // pero se mantienen para cumplir la interfaz Vista. Si no los necesitas para otra lógica, podrías quitarlos
        // de la interfaz Vista en el futuro, pero por ahora déjalos.
        // vistaPrincipal.setModelo(modelo); // Ya se hizo en el constructor
        // vistaPrincipal.setControlador(controlador); // Ya se hizo en el constructor


        // 5. Configurar la Escena y el Stage
        Scene scene = new Scene(vistaPrincipal.getView(), 1100, 500);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm()); // Verifica esta ruta

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de Recomendación Musical");
        primaryStage.show();
    }
}