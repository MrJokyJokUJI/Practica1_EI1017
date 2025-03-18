// COMENTADO

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
        this.rows = new ArrayList<>(); // Asegura que las filas sean del tipo correcto
        for (RowWithLabel row : rows) {
            addRow(row); // Añadimos las filas y actualizamos el mapa de etiquetas
        }
    }
    @Override
    public RowWithLabel getRowAt(int index) {
        return (RowWithLabel) super.getRowAt(index);
    }
    public Integer getLabelAsInteger(String label) {
        return labelsToIndex.get(label);
    }

    // SVEN: no es consistente tener aquí un "addRow", pero en Table no.
    public void addRow(RowWithLabel row) {
        String label = row.getLabel();

        if (!labelsToIndex.containsKey(label)) {
            labelsToIndex.put(label, labelsToIndex.size());
        }

        // si tienes un addRow en Table, aquí lo podrías llamar
        super.rows.add(row);
    }


}









