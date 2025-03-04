package es.uji.al439012.KNN;

import es.uji.al439012.table.RowWithLabel;
import es.uji.al439012.table.TableWithLabels;

import java.util.List;

public class KNN {
    private TableWithLabels trainingData;

    public void train(TableWithLabels data) {
        if (data == null || data.getRowCount() == 0) {
            throw new IllegalArgumentException("Los datos de entrenamiento no son válidos.");
        }

        this.trainingData = data;
        System.out.println("Entrenamiento completado. Total de filas: " + data.getRowCount());

        for (int i = 0; i < data.getRowCount(); i++) {
            RowWithLabel row = data.getRowAt(i);
            System.out.println("Fila " + i + ": " + row + " -> Etiqueta: " + row.getLabel());
        }
    }

    public Integer estimate(List<Double> sample) {
        if (trainingData == null || trainingData.getRowCount() == 0) {
            throw new IllegalStateException("El modelo KNN no ha sido entrenado.");
        }

        RowWithLabel closestRow = null;
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < trainingData.getRowCount(); i++) {
            RowWithLabel row = trainingData.getRowAt(i);
            if (row == null) {
                System.err.println("Fila nula en índice: " + i);
                continue;
            }

            double distance = euclideanDistance(sample, row.getData());
            if (distance < minDistance) {
                minDistance = distance;
                closestRow = row;
            }
        }

        if (closestRow != null) {
            String label = closestRow.getLabel();
            Integer labelAsInteger = trainingData.getLabelAsInteger(label);

            if (labelAsInteger == null) {
                throw new IllegalStateException("Etiqueta no encontrada: " + label);
            }
            return labelAsInteger;
        }

        return null;
    }

    private double euclideanDistance(List<Double> a, List<Double> b) {
        double sum = 0.0;
        for (int i = 0; i < a.size(); i++) {
            sum += Math.pow(a.get(i) - b.get(i), 2);
        }
        return Math.sqrt(sum);
    }
}
