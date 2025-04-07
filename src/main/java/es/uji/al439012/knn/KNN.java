// COMENTADO
//
// APTO
//
// - ver comentarios detallados en el código
// - es necesario comprobar en tantos lugares si un valor on es null? (ver comentarios en código)
// - cuidado con la consistencia (ver comentarios en código)
// - Generalmente buena solución pero cuidado con los detalles

package es.uji.al439012.knn;

import es.uji.al439012.algorithm.EuclideanDistance;
import es.uji.al439012.algorithm.Algorithm;
import es.uji.al439012.table.RowWithLabel;
import es.uji.al439012.table.TableWithLabels;
import es.uji.al439012.algorithm.Distance;
import java.util.List;

public class KNN implements Algorithm<TableWithLabels> {
    private TableWithLabels trainingData;
    private Distance distance;

    public KNN() {
        this(new EuclideanDistance()); // Usa EuclideanDistance por defecto
    }

    public KNN(Distance distance) {
        if (distance == null) {
            throw new IllegalArgumentException("El objeto Distance no puede ser null");
        }
        this.distance = distance;
    }

    public void train(TableWithLabels data) {
        if (data == null || data.getRowCount() == 0) {
            throw new IllegalArgumentException("Los datos de entrenamiento no son válidos.");
        }
        this.trainingData = data;
    }

    public Integer estimate(List<Double> sample) {
        if (trainingData == null || trainingData.getRowCount() == 0) {
            throw new IllegalStateException("El modelo KNN no ha sido entrenado.");
        }

        RowWithLabel closestRow = null;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < trainingData.getRowCount(); i++) {
            RowWithLabel row = trainingData.getRowAt(i);
            double currentDistance = distance.calculateDistance(sample, row.getData());

            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                closestRow = row;
            }
        }

        return (closestRow != null) ? trainingData.getLabelAsInteger(closestRow.getLabel()) : null;
    }
}
