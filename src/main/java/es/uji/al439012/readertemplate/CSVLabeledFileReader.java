package es.uji.al439012.readertemplate;

import es.uji.al439012.table.RowWithLabel;
import es.uji.al439012.table.TableWithLabels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import es.uji.al439012.readertemplate.ReaderTemplate;

public class CSVLabeledFileReader extends FileReader<TableWithLabels> {
    private TableWithLabels table;

    public CSVLabeledFileReader(String s) {
        super(s);
    }

    @Override
    public void processHeaders(String headersLine) {
        List<String> headers = new ArrayList<>(Arrays.asList(headersLine.split(",")));
        headers.remove(headers.size() - 1); // Remove last column (label)
        table = new TableWithLabels(headers);
    }

    @Override
    public void processData(String dataLine) {
        String[] parts = dataLine.split(",");
        List<Double> data = new ArrayList<>();

        for (int i = 0; i < parts.length - 1; i++) {
            data.add(Double.parseDouble(parts[i]));
        }

        String label = parts[parts.length - 1].trim();
        table.addRow(new RowWithLabel(data, label));
    }

    @Override
    protected TableWithLabels getTable() {
        return table;
    }
}
