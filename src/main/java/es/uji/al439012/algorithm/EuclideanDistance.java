package es.uji.al439012.algorithm;

import java.util.List;

public class EuclideanDistance implements Distance {
    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        double sum = 0.0;
        for (int i = 0; i < p.size(); i++) {
            sum += Math.pow(p.get(i) - q.get(i), 2);
        }
        return Math.sqrt(sum);
    }
}
