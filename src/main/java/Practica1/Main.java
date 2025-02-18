package Practica1;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            CSV csv = new CSV();
            Table table = csv.readTable("milles_dollars.csv");

            System.out.println("Tabla cargada desde CSV:");
            table.showTable();

            System.out.println("\nPrimera fila: " + table.getRowAt(0));
            System.out.println("Columna Miles: " + table.getColumnAt(0));
            System.out.println("Columna Dollars: " + table.getColumnAt(1));

        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}