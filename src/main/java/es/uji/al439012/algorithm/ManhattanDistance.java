package es.uji.al439012.algorithm;


import java.util.List;

public class ManhattanDistance implements Distance {
    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        double sum = 0.0;
        for (int i = 0; i < p.size(); i++) {
            sum += Math.abs(p.get(i) - q.get(i));
        }
        return sum;
    }
}