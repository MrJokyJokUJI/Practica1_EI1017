package es.uji.al439012.readertemplate;

import es.uji.al439012.table.Row;
import es.uji.al439012.table.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUnlabeledFileReader extends FileReader<Table> {
    private List<String> headers;
    private List<Row> rows;

    public CSVUnlabeledFileReader() {
        rows = new ArrayList<>();
    }

    @Override
    public void processHeaders(String headersLine) {
        headers = Arrays.asList(headersLine.split(","));
    }

    @Override
    public void processData(String dataLine) {
        String[] values = dataLine.split(",");
        List<Double> data = new ArrayList<>();
        for (String value : values) {
            data.add(Double.parseDouble(value));
        }
        rows.add(new Row(data));
    }

    @Override
    protected Table getTable() {
        return new Table(headers, rows);
    }
}
