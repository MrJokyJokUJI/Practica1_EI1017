package es.uji.al439012.kmeans;

import es.uji.al439012.excepciones.InvalidClusterNumberException;
import es.uji.al439012.table.Table;
import es.uji.al439012.algorithm.Algorithm;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KMeans implements Algorithm<Table> {
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
        validateClusterNumber(data);
        List<List<Double>> rows = initializeDataRows(data);
        initializeCentroids(rows);

        for (int i = 0; i < numIterations; i++) {
            updateCentroids(rows);
        }
    }

    private void validateClusterNumber(Table data) throws InvalidClusterNumberException {
        if (numClusters > data.getRowCount()) {
            throw new InvalidClusterNumberException(numClusters, data.getRowCount());
        }
    }

    private List<List<Double>> initializeDataRows(Table data) {
        List<List<Double>> rows = new ArrayList<>();
        for (int i = 0; i < data.getRowCount(); i++) {
            rows.add(new ArrayList<>(data.getRowAt(i).getData())); // Deep copy
        }
        return rows;
    }

    private void initializeCentroids(List<List<Double>> rows) {
        Collections.shuffle(rows, random);
        centroids = new ArrayList<>(rows.subList(0, numClusters));
    }

    private void updateCentroids(List<List<Double>> rows) {
        int[] clusterSizes = new int[numClusters];
        List<List<Double>> sumCoordinates = new ArrayList<>();

        for (int j = 0; j < numClusters; j++) {
            sumCoordinates.add(new ArrayList<>(Collections.nCopies(rows.get(0).size(), 0.0)));
        }

        for (List<Double> row : rows) {
            int cluster = getNearestCentroid(row);
            clusterSizes[cluster]++;
            addCoordinates(sumCoordinates.get(cluster), row);
        }

        centroids = IntStream.range(0, numClusters)
                .mapToObj(j -> clusterSizes[j] > 0 ? averageCoordinates(sumCoordinates.get(j), clusterSizes[j])
                        : new ArrayList<>(centroids.get(j)))
                .collect(Collectors.toList());
    }

    public Integer estimate(List<Double> dataPoint) {
        if (centroids.isEmpty()) {
            throw new IllegalStateException("Model has not been trained yet.");
        }
        return getNearestCentroid(dataPoint);
    }

    private int getNearestCentroid(List<Double> dataPoint) {
        return IntStream.range(0, centroids.size())
                .boxed()
                .min(Comparator.comparingDouble(i -> euclideanDistance(dataPoint, centroids.get(i))))
                .orElse(0);
    }

    private double euclideanDistance(List<Double> p1, List<Double> p2) {
        return Math.sqrt(IntStream.range(0, p1.size())
                .mapToDouble(i -> Math.pow(p1.get(i) - p2.get(i), 2))
                .sum());
    }

    private void addCoordinates(List<Double> sum, List<Double> row) {
        IntStream.range(0, sum.size()).forEach(i -> sum.set(i, sum.get(i) + row.get(i)));
    }

    private List<Double> averageCoordinates(List<Double> sum, int count) {
        return sum.stream().map(val -> val / count).collect(Collectors.toList());
    }
}
