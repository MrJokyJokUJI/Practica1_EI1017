package es.uji.al439012.gui.controlador;

import es.uji.al439012.algorithm.Distance;
import es.uji.al439012.algorithm.EuclideanDistance;
import es.uji.al439012.algorithm.ManhattanDistance;

public class DisFactory {
    public static Distance createDistance(String type) {
        if (type == null) {
            throw new IllegalArgumentException("El tipo no puede ser null");
        }

        switch (type.toLowerCase()) {
            case "euclediana":
                return new EuclideanDistance();
            case "manhattan":
                return new ManhattanDistance();
            default:
                throw new IllegalArgumentException("Tipo de distancia desconocido: " + type);
        }
    }
}
