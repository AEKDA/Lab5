package models;

import java.util.Stack;
import java.util.Date;
import java.time.Instant;
import java.util.Collections;
import java.util.Scanner;

import logic.CollectionManager;
import io.JSONLoaer;
import io.Loader;
import io.Logger;
import logic.Args;

public class MovieCollection implements CollectionManager<Movie> {
    private static MovieCollection instance = null;
    private Stack<Movie> collectionStack;
    private final Date initDate;

    public static MovieCollection getInstance() {
        if (instance == null) {
            instance = new MovieCollection();
        }
        return instance;
    }
    
    private MovieCollection() {
        collectionStack = new Stack<>();
        initDate = Date.from(Instant.now());
    }

    public void setStartData() {
        String path = Args.getPathToFile();
        if (Args.getArgs().length != 1) {
            Logger.get().writeLine("Error! You didn't specify the path to the file");
            Logger.get().writeLine("Entered File path: ");
            Scanner in = new Scanner(System.in);
            path = in.nextLine();

        } else {
            path = Args.getArgs()[0];
        }
        Loader<Movie> io = new JSONLoaer<>();
        Movie[] loadMovies = io.read(path);
        MovieCollection.getInstance().setData(loadMovies);
    }

    public void clear() {
        collectionStack.clear();
    }

    public Stack<Movie> getData() {
        return collectionStack;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setData(Movie[] movieData) {
        Collections.addAll(collectionStack, movieData);
    }

    public void pushElement(Movie t) {
        collectionStack.push(t);
    }
}
