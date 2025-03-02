package es.uji.al439012.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String, Integer> labelsToIndex;

    // Constructor original
    public TableWithLabels(List<String> headers) {
        super(headers);
        this.labelsToIndex = new HashMap<>();
        this.rows = new ArrayList<>();
    }

    // Nuevo constructor que permite inyección directa de filas
    public TableWithLabels(List<String> headers, List<RowWithLabel> rows) {
        super(headers);
        this.labelsToIndex = new HashMap<>();
        this.rows = new ArrayList<>(rows); // Asegura que las filas sean del tipo correcto
    }
    @Override
    public RowWithLabel getRowAt(int index) {
        return (RowWithLabel) super.getRowAt(index);
    }


    public Integer getLabelAsInteger(String label) {
        return labelsToIndex.get(label);
    }

    public void addRow(RowWithLabel row) {
        String label = row.getLabel();

        if (!labelsToIndex.containsKey(label)) {
            labelsToIndex.put(label, labelsToIndex.size());
        }

        super.rows.add(row);
    }


}




