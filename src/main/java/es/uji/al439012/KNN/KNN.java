package es.uji.al439012.KNN;
/*nigger*/
import es.uji.al439012.table.RowWithLabel;
import es.uji.al439012.table.TableWithLabels;

import java.util.List;

public class KNN {
    private TableWithLabels trainingData;

    public void train(TableWithLabels data) {
        this.trainingData = data;
    }

    public Integer estimate(List<Double> sample) {
        if (trainingData == null || trainingData.getRowAt(0) == null) {
            throw new IllegalStateException("El modelo KNN no ha sido entrenado.");
        }

        RowWithLabel closestRow = null;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < trainingData.getRowCount(); i++) {
            RowWithLabel row = trainingData.getRowAt(i);
            double distance = euclideanDistance(sample, row.getData());
            if (distance < minDistance) {
                minDistance = distance;
                closestRow = row;
            }
        }

        return closestRow != null ? trainingData.getLabelAsInteger(closestRow.getLabel()) : null;
    }

    private double euclideanDistance(List<Double> a, List<Double> b) {
        double sum = 0.0;
        for (int i = 0; i < a.size(); i++) {
            sum += Math.pow(a.get(i) - b.get(i), 2);
        }
        return Math.sqrt(sum);
    }
}
