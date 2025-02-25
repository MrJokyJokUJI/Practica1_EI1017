package es.uji.al439012.table;

import java.util.List;

public class Row {
    private List<Double> data;

    public Row(List<Double> data) {
        this.data = data;
    }

    public List<Double> getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
