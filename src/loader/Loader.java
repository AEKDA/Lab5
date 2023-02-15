package loader;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Stack;

import java.time.ZonedDateTime;

import data.Movie;

public abstract class Loader<T> {

    public void read(String path) {

    }
    public void write(String path) {
        
    }

    public abstract void parse(String data);
    public abstract LinkedList<T> getData();
}
