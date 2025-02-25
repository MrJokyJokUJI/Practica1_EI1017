package es.uji.al439012.csv;

import es.uji.al439012.table.Row;
import es.uji.al439012.table.Table;

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
}
