package loader;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public abstract class Loader<T> {
    private BaseReader baseReader;

    public void read(String path) {
        try {
            baseReader = new BaseReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден");
        }
        parse(baseReader.read());
    }
    public void write(String path) {
        
    }

    public abstract void parse(String data);
    public abstract LinkedList<T> getData();
}
