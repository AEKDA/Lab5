package fileLoader;

import java.util.Stack;

public class Loader<T> {
    private Stack<T> data;

    public Loader() {
        data = new Stack<>();
    }

    public void readJSONFile(String path) {

    }
    
    public Stack<T> getData() {
        return data;
    }


}
