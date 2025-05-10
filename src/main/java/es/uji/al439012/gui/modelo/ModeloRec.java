package es.uji.al439012.gui.modelo; // O el paquete que designes para el modelo

import es.uji.al439012.algorithm.Algorithm;
import es.uji.al439012.csv.CSV;
import es.uji.al439012.gui.vista.ImplementaciónVista;
import es.uji.al439012.knn.KNN;
import es.uji.al439012.recSys.RecSys;
import es.uji.al439012.table.Table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModeloRec implements Modelo {

    private ImplementaciónVista vista;

    private List<String> songTitles; // Almacena la lista de canciones una vez cargada

    private String separator = System.getProperty("file.separator");
    private String songsFolder = "recommender";

    private RecSys recSys;
    private Algorithm algorithm;

    private Table trainTable;

    // Podrías cargar las canciones en el constructor o la primera vez que se piden

    @Override
    public List<String> getAllSongTitles() {
        if (songTitles == null) { // Carga "lazy" si aún no se han cargado
            songTitles = loadSongsFromCSV();
        }
        // Devuelve una copia para evitar modificaciones externas no deseadas
        return new ArrayList<>(songTitles);
    }

    @Override
    public List<String> getRecommendations(String selectedSong, String recommendationType, String distanceType, int numberOfRecommendations) throws Exception {
        // Aquí iría la lógica para llamar a tu sistema de recomendación (RecSys, etc.)
        // ... implementación ...

        trainTable = new CSV().readTableWithLabels(songsFolder + separator + "songs_train.csv");

        algorithm = new KNN();
        recSys = new RecSys(algorithm);
        recSys.train(trainTable);


        System.out.println("Modelo: Calculando recomendaciones..."); // Placeholder
        List<String> recommendations = new ArrayList<>();
        recommendations.add("Canción recomendada 1 basada en " + selectedSong);
        recommendations.add("Canción recomendada 2 basada en " + selectedSong);
        return recommendations; // Placeholder
    }

    public void setVista(ImplementaciónVista vista) {
        this.vista = vista;
    }


    private List<String> loadSongsFromCSV() {
        List<String> loadedSongs = new ArrayList<>();
        String path = "src/main/resources/recommender/songs_test_names.csv"; // Idealmente, esta ruta no debería estar hardcodeada aquí

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                loadedSongs.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error cargando canciones en el Modelo: " + e.getMessage());
            // Considera lanzar una excepción personalizada o manejar el error de otra forma
        }
        System.out.println("Modelo: Canciones cargadas desde CSV."); // Placeholder
        return loadedSongs;
    }

    // Implementación del patrón observador si es necesario...
}
