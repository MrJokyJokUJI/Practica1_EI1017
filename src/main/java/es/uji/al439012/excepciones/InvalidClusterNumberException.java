package es.uji.al439012.excepciones;

public class InvalidClusterNumberException extends Exception {
    private int numClusters;
    private int numRows;

    public InvalidClusterNumberException(int numClusters, int numRows) {
        super("Número de clusters (" + numClusters + ") mayor que el número de filas (" + numRows + ")");
        this.numClusters = numClusters;
        this.numRows = numRows;
    }

    public int getNumberOfCusters() {
        return numClusters;
    }

    public int getNumberOfRows() {
        return numRows;
    }
}
