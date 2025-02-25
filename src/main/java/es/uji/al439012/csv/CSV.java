package es.uji.al439012.csv;

import es.uji.al439012.table.Row;
import es.uji.al439012.table.Table;
import es.uji.al439012.table.TableWithLabels;
import es.uji.al439012.table.RowWithLabel;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {
    public Table readTable(String fileName) throws IOException {
        try {
            String filePath = getClass().getClassLoader().getResource(fileName).toURI().getPath();

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            List<String> headers = Arrays.asList(line.split(","));
            List<Row> rows = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                List<Double> data = new ArrayList<>();

                for (String value : values) {
                    data.add(Double.parseDouble(value));
                }

                rows.add(new Row(data));
            }

            br.close();
            return new Table(headers, rows);

        } catch (URISyntaxException | NullPointerException e) {
            throw new IOException("Error al obtener el archivo CSV: " + fileName, e);
        }
    }

    public TableWithLabels readTableWithLabels(String irisFile) {
        TableWithLabels table = null;
        try (BufferedReader br = new BufferedReader(new FileReader(irisFile))) {
            String line = br.readLine();
            if (line != null) {
                List<String> headers = List.of(line.split(","));
                table = new TableWithLabels(headers);
            }
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                List<Double> data = new ArrayList<>();
                for (int i = 0; i < parts.length - 1; i++) {
                    data.add(Double.parseDouble(parts[i]));
                }
                String label = parts[parts.length - 1];
                RowWithLabel row = new RowWithLabel(data, label);
                table.addRow(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }
}