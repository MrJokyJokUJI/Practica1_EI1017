package es.uji.al439012.gui.vista;

import es.uji.al439012.gui.controlador.Controlador;
import es.uji.al439012.gui.modelo.Modelo;
import javafx.scene.layout.HBox;

import java.util.List;

/**
 * Interfaz para la Vista en el patrón MVC.
 * Define los métodos para interactuar con la interfaz de usuario.
 */
public interface Vista {

    /**
     * Obtiene las canciones seleccionadas por el usuario en la lista.
     *
     * @return Una lista de nombres de canciones seleccionadas.
     */
    String getSelectedSong();

    /**
     * Obtiene el tipo de recomendación seleccionado por el usuario (p.ej., "Similitudes", "Genero").
     *
     * @return El tipo de recomendación como String.
     */
    String getRecommendationType();

    /**
     * Obtiene el tipo de distancia seleccionada por el usuario (p.ej., "Euclediana", "Manhattan").
     *
     * @return El tipo de distancia como String.
     */
    String getDistanceType();

    /**
     * Obtiene el número de recomendaciones solicitado por el usuario.
     *
     * @return El número de recomendaciones.
     */
    int getNumberOfRecommendations();

    /**
     * Muestra las canciones recomendadas en el área designada de la interfaz.
     *
     * @param recommendations Lista de nombres de canciones recomendadas.
     */
    void showRecommendations(List<String> recommendations);

    void setControlador(Controlador controlador);

    void setModelo(Modelo modelo);

    public HBox getView();

    /**
     * Muestra un mensaje de error o informativo al usuario.
     * @param message El mensaje a mostrar.
     */
    //void showMessage(String message);

    /**
     * Habilita o deshabilita el botón de recomendación.
     * Útil para prevenir acciones cuando no se cumplen las condiciones (p.ej., no hay canción seleccionada)[cite: 23].
     * @param enable true para habilitar, false para deshabilitar.
     */
    //void setRecommendButtonEnabled(boolean enable);

    // Podrían añadirse otros métodos para actualizar diferentes partes de la UI si fuera necesario.
}
