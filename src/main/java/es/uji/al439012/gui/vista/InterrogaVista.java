package es.uji.al439012.gui.vista;

import es.uji.al439012.gui.modelo.InterrogaModelo;
import es.uji.al439012.gui.modelo.Modelo;
import javafx.scene.layout.HBox;

import java.util.List;

/**
 * Interfaz para la parte de la Vista que se encarga de obtener entradas del usuario.
 */
public interface InterrogaVista {

    /**
     * Obtiene la canción seleccionada por el usuario en la lista.
     *
     * @return El nombre de la canción seleccionada.
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

    public HBox getView();

    public void setModelo(InterrogaModelo modelo);
}
