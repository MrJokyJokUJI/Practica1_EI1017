package es.uji.al439012.gui.controlador;

import es.uji.al439012.gui.modelo.Modelo;
import es.uji.al439012.gui.vista.Vista;

/**
 * Interfaz para el Controlador en el patrón MVC.
 * Define los métodos para manejar las acciones del usuario y coordinar Modelo y Vista.
 */
public interface Controlador {

    /**
     * Maneja la acción de solicitar recomendaciones (p.ej., clic en el botón "MOSTRAR RECOMENDACIONES").
     * El controlador obtendrá los datos necesarios de la vista, pedirá las recomendaciones al modelo
     * y actualizará la vista con los resultados.
     */
    void botonRecPulsado();

    /**
     * Se podría llamar cuando cambia la selección de canciones en la vista,
     * por ejemplo, para habilitar/deshabilitar el botón de recomendar[cite: 23].
     */
    void onSongSelectionChanged();

    // Se podrían añadir otros métodos para manejar diferentes eventos de la UI
    // (cambio en ComboBox, Spinner, etc.) si se requiere una lógica de controlador específica.

    void setVista(Vista vista);

    void setModelo(Modelo modelo);
}
