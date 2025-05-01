package es.uji.al439012.gui.modelo; // Asumiendo un paquete 'modelo'

import es.uji.al439012.gui.vista.Vista;

import java.util.List;

/**
 * Interfaz para el Modelo en el patrón MVC.
 * Define los métodos para gestionar los datos y la lógica de negocio (recomendaciones).
 */
public interface Modelo {



    /**
     * Obtiene la lista completa de canciones disponibles.
     * @return Una lista con los nombres de todas las canciones.
     */
    List<String> getAllSongTitles();

    /**
     * Calcula y devuelve una lista de canciones recomendadas.
     * @param selectedSongs Las canciones base para la recomendación.
     * @param recommendationType El algoritmo o tipo de recomendación a usar (p.ej., "Similitudes").
     * @param distanceType El tipo de métrica de distancia (p.ej., "Euclediana").
     * @param numberOfRecommendations El número máximo de recomendaciones a devolver.
     * @return Una lista con los nombres de las canciones recomendadas.
     * @throws Exception Si ocurre un error durante el cálculo.
     */
    List<String> getRecommendations(List<String> selectedSongs, String recommendationType, String distanceType, int numberOfRecommendations) throws Exception;

    void setVista(Vista vista);

    // --- Patrón Observador (Opcional pero recomendado para MVC) ---
    // El modelo podría implementar un mecanismo para que las Vistas (u Observadores) se registren
    // y sean notificadas de cambios en los datos[cite: 14].

    // void addChangeListener(IModelChangeListener listener);
    // void removeChangeListener(IModelChangeListener listener);

}

// Interfaz para el patrón Observador (si se implementa)
// public interface IModelChangeListener {
//    void onModelChanged();
// }
