// Modifica ControladorRec.java

package es.uji.al439012.gui.controlador;

import es.uji.al439012.gui.modelo.Modelo;
import es.uji.al439012.gui.vista.Vista;

import java.util.List; // Importar List

public class ControladorRec implements Controlador {

    private Modelo modelo; // Guarda la referencia al Modelo
    private Vista vista; // Guarda la referencia a la Vista

    // --- Constructor sin argumentos ---
    public ControladorRec() {
        // Constructor vacío. Las dependencias (Modelo y Vista) se setean después.
    }

    // --- Constructor con argumentos (Opcional, si prefieres inyectar aquí) ---
    /*
    public ControladorRec(Modelo modelo, Vista vista) {
        if (modelo == null) {
             throw new IllegalArgumentException("El modelo no puede ser nulo en el Controlador");
        }
         if (vista == null) {
             throw new IllegalArgumentException("La vista no puede ser nula en el Controlador");
        }
        this.modelo = modelo;
        this.vista = vista;
    }
    */


    @Override
    public void botonRecPulsado() {
        System.out.println("--- Controlador: Botón de recomendación pulsado ---");

        // 1. Obtener datos de la Vista usando los métodos de la interfaz Vista
        // Verificamos que la vista no sea null antes de usarla
        if (this.vista == null) {
            System.err.println("Error: Vista no establecida en el Controlador.");
            return;
        }

        String cancionSeleccionada = vista.getSelectedSong();
        String tipoRecomendacion = vista.getRecommendationType();
        String tipoDistancia = vista.getDistanceType();
        int numRecomendaciones = vista.getNumberOfRecommendations();


        // 2. Mostrar la información por pantalla (consola)
        System.out.println("Controlador: Información recibida de la Vista:");
        if (cancionSeleccionada != null && !cancionSeleccionada.isEmpty()) {
            System.out.println("  Cancion seleccionada: " + cancionSeleccionada);
        } else {
            System.out.println("  (Ninguna canción seleccionada)");
        }

        System.out.println("  Tipo de recomendación: " + tipoRecomendacion);
        System.out.println("  Tipo de distancia: " + tipoDistancia);
        System.out.println("  Número de recomendaciones: " + numRecomendaciones);

        System.out.println("----------------------------------------------");

        // --- Lógica futura para interactuar con el Modelo ---

        // 3. Pasar datos al Modelo para que haga el cálculo
        try {
            List<String> recomendaciones = modelo.getRecommendations(
                cancionSeleccionada,
                tipoRecomendacion,
                tipoDistancia,
                numRecomendaciones
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 4. Pedirle a la Vista que muestre el resultado
        //     vista.showRecommendations(recomendaciones);

    }

    @Override
    public void onSongSelectionChanged() {
        // Lógica para manejar el cambio en la selección de canciones (aún no implementada)
        // Por ejemplo, podrías deshabilitar/habilitar el botón de recomendar aquí.
        // if (vista != null) {
        //     boolean hasSelection = vista.getSelectedSongs() != null && !vista.getSelectedSongs().isEmpty();
        //     vista.setRecommendButtonEnabled(hasSelection); // Asumiendo un método setRecommendButtonEnabled en Vista
        // }
        System.out.println("Controlador: Selección de canciones cambiada.");
    }

    // Métodos para establecer la Vista y el Modelo (necesarios si no usas el constructor con argumentos para inyección completa)
    @Override
    public void setVista(Vista vista) {
        this.vista = vista;
    }

    @Override
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
