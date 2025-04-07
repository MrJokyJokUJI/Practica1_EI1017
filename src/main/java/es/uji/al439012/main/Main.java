package es.uji.al439012.main;

import es.uji.al439012.csv.CSV;
import es.uji.al439012.table.Table;
import es.uji.al439012.table.TableWithLabels;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            CSV csv = new CSV();
            Table table = csv.readTable("miles_dollars.csv");

            System.out.println("Tabla cargada desde CSV:");
            table.showTable();

            System.out.println("\nPrimera fila: " + table.getRowAt(0));
            System.out.println("Columna Miles: " + table.getColumnAt(0));
            System.out.println("Columna Dollars: " + table.getColumnAt(1));

            CSV csvLabel = new CSV();
            TableWithLabels tableLabel = csv.readTableWithLabels("iris.csv");

            System.out.println("Tabla cargada desde CSV:");
            table.showTable();

            System.out.println("\nPrimera fila: " + tableLabel.getRowAt(0));
            System.out.println("Columna sepal length: " + tableLabel.getColumnAt(0));
            System.out.println("Columna sepal width: " + tableLabel.getColumnAt(1));
            System.out.println("Columna petal length: " + tableLabel.getColumnAt(2));
            System.out.println("Columna petal width: " + tableLabel.getColumnAt(3));

        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}

