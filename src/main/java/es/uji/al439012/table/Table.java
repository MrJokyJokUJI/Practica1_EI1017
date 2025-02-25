package es.uji.al439012.table;

import java.util.List;
import java.util.stream.Collectors;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table(List<String> headers, List<Row> rows) {
        this.headers = headers;
        this.rows = rows;
    }

    public Row getRowAt(int index) {
        return rows.get(index);
    }

    public List<Double> getColumnAt(int index) {
        return rows.stream()
                .map(row -> row.getData().get(index))
                .collect(Collectors.toList());
    }

    public void showTable() {
        System.out.println(headers);
        for (Row row : rows) {
            System.out.println(row);
        }
    }
}
