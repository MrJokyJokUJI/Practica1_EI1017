package es.uji.al439012.algorithm;

import java.util.List;

public interface Algorithm<T> {
    void train(T data);
    Integer estimate(List<Double> dato);
}
