package es.uji.al439012.gui.controlador;

import es.uji.al439012.algorithm.Algorithm;
import es.uji.al439012.algorithm.Distance;
import es.uji.al439012.kmeans.KMeans;
import es.uji.al439012.knn.KNN;

import java.util.Random;

public class AlgoFactory {
    public static Algorithm<?> createAlgorithm(String tipoAlgoritmo, Distance distance) {
        tipoAlgoritmo = tipoAlgoritmo.toLowerCase();
        long semilla = 0;
        Random random = new Random(semilla);

        if (tipoAlgoritmo.contains("genero")) {
            // Por defecto: 3 clusters, 100 iteraciones, semilla 42
            return new KMeans(3, 100, semilla, distance);
        } else if (tipoAlgoritmo.contains("similitudes")) {
            return new KNN(distance);
        } else {
            throw new IllegalArgumentException("Tipo de algoritmo desconocido: " + tipoAlgoritmo);
        }
    }
}
