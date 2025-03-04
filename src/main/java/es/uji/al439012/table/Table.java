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
    public Table(List<String> headers ) {
        this.headers = headers;
        this.rows = null;
    }


    public Row getRowAt(int index) {
        return rows.get(index);
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
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