package es.uji.al439012.KMeans;

import es.uji.al439012.excepciones.InvalidClusterNumberException;
import es.uji.al439012.table.Table;

import java.util.*;

public class KMeans {
    private int numClusters;
    private int numIterations;
    private Random random;
    private List<List<Double>> centroids;

    public KMeans(int numClusters, int numIterations, long seed) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.random = new Random(seed);
        this.centroids = new ArrayList<>();
    }

    public void train(Table data) throws InvalidClusterNumberException {
        if (numClusters > data.getRowCount()) {
            throw new InvalidClusterNumberException(numClusters, data.getRowCount());
        }

        // Inicializar centroides aleatorios
        List<List<Double>> rows = new ArrayList<>();
        for (int i = 0; i < data.getRowCount(); i++) {
            rows.add(data.getRowAt(i).getData());
        }
        Collections.shuffle(rows, random);
        centroids = rows.subList(0, numClusters);

        // Iteraciones para actualizar centroides
        for (int i = 0; i < numIterations; i++) {
            List<List<Double>> newCentroids = new ArrayList<>(Collections.nCopies(numClusters, null));
            int[] clusterSizes = new int[numClusters];
            List<List<Double>> sumCoordinates = new ArrayList<>(Collections.nCopies(numClusters, new ArrayList<>(Collections.nCopies(rows.get(0).size(), 0.0))));

            for (List<Double> row : rows) {
                int cluster = getNearestCentroid(row);
                clusterSizes[cluster]++;
                addCoordinates(sumCoordinates.get(cluster), row);
            }

            for (int j = 0; j < numClusters; j++) {
                if (clusterSizes[j] > 0) {
                    newCentroids.set(j, averageCoordinates(sumCoordinates.get(j), clusterSizes[j]));
                } else {
                    newCentroids.set(j, centroids.get(j));
                }
            }
            centroids = newCentroids;
        }
    }

    public int estimate(List<Double> dataPoint) {
        return getNearestCentroid(dataPoint);
    }

    private int getNearestCentroid(List<Double> dataPoint) {
        int nearest = 0;
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < centroids.size(); i++) {
            double distance = euclideanDistance(dataPoint, centroids.get(i));
            if (distance < minDistance) {
                minDistance = distance;
                nearest = i;
            }
        }
        System.out.println("Punto asignado al cluster: " + nearest);
        return nearest;
    }

    private double euclideanDistance(List<Double> p1, List<Double> p2) {
        double sum = 0.0;
        for (int i = 0; i < p1.size(); i++) {
            sum += Math.pow(p1.get(i) - p2.get(i), 2);
        }
        return Math.sqrt(sum);
    }

    private void addCoordinates(List<Double> sum, List<Double> row) {
        for (int i = 0; i < row.size(); i++) {
            sum.set(i, sum.get(i) + row.get(i));
        }
    }

    private List<Double> averageCoordinates(List<Double> sum, int count) {
        List<Double> average = new ArrayList<>();
        for (Double value : sum) {
            average.add(value / count);
        }
        return average;
    }
}

