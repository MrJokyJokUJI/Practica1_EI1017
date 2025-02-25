package es.uji.al439012.table;

import java.util.List;

public class RowWithLabel extends Row {
    private String label;

    public RowWithLabel(List<Double> data, String label) {
        super(data);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return super.toString() + ", label=" + label;
    }
}
