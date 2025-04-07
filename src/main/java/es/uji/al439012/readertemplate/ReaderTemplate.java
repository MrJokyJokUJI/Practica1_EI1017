package es.uji.al439012.readertemplate;

import es.uji.al439012.table.Table;

public abstract class ReaderTemplate<T extends Table> {
    public abstract void openSource(String source);
    public abstract void processHeaders(String headers);
    public abstract void processData(String data);
    public abstract void closeSource();
    public abstract boolean hasMoreData();
    public abstract String getNextData();

    public final T readTableFromSource(String source) {
        openSource(source);
        processHeaders(getNextData());
        while (hasMoreData()) {
            processData(getNextData());
        }
        closeSource();
        return getTable();
    }

    protected abstract T getTable();
}
