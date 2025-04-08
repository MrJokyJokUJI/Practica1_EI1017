package es.uji.al439012.readertemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import es.uji.al439012.table.Table;

public abstract class FileReader<T extends Table> extends ReaderTemplate<T> {

    public FileReader(String source) {
        super(source);
    }

    protected Scanner scanner;

    @Override
    public void openSource(String source) {
        try {
            String filePath = getClass().getClassLoader().getResource(source).toURI().getPath();
            scanner = new Scanner(new File(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Error al abrir el archivo: " + source, e);
        }
    }

    @Override
    public boolean hasMoreData() {
        return scanner.hasNextLine();
    }

    @Override
    public String getNextData() {
        return scanner.nextLine();
    }

    @Override
    public void closeSource() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
