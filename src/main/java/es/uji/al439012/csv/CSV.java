// COMENTADO
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

        String filePath = null;
        try {
            filePath = getClass().getClassLoader().getResource(fileName).toURI().getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

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
    }

    public TableWithLabels readTableWithLabels(String irisFile) {
        TableWithLabels table = null;
        try {
            String filePath = getClass().getClassLoader().getResource(irisFile).toURI().getPath();
            System.out.println("Ruta del archivo: " + filePath);

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            if (line != null) {
                List<String> headers = new ArrayList<>(Arrays.asList(line.split(","))); // Lista modificable
                headers.remove(headers.size() - 1); // Quitar el último elemento
                table = new TableWithLabels(headers);
            }


            while ((line = br.readLine()) != null) {
                System.out.println("Línea CSV: " + line);  // Depuración

                String[] parts = line.split(",");
                List<Double> data = new ArrayList<>();

                for (int i = 0; i < parts.length - 1; i++) {
                    data.add(Double.parseDouble(parts[i]));
                }

                String label = parts[parts.length - 1].trim();
                RowWithLabel row = new RowWithLabel(data, label);
                table.addRow(row);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return table;
    }
}