// COMENTADO

package es.uji.al439012.table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table {
    private List<String> headers;
    List<Row> rows;

    public Table(List<String> headers, List<Row> rows) {
        this.headers = headers;
        this.rows = rows;
    }

    // SVEN: tener este constructor, sín una manera de añadir un row (addRow), no tiene mucho sentido.
    // Significa que podemos crear un Table en lo cual no podemos añadir nada.
    public Table(List<String> headers ) {
        this.headers = headers;
        this.rows = new ArrayList<>();
    }


    public Row getRowAt(int index) {
        return rows.get(index);
    }

    public List<Double> getColumnAt(int index) {
        List<Double> column = new ArrayList<>();
        for (Row row : rows) {
            column.add(row.getData().get(index));
        }
        return column;
    }

    public List<String> getHeaders() {
        return headers;
    }
    public void showTable() {
        System.out.println(headers);
        for (Row row : rows) {
            System.out.println(row);
        }
    }
    public int getRowCount() {
        return rows.size();


    }
}