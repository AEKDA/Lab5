package models;

import java.util.Collections;
import java.util.Stack;
import java.time.ZonedDateTime;
import java.io.File;

import logic.CollectionManager;
import logic.Args;
import logic.CollectionInfo;
import io.Loader;
import io.JSONCollectionInfoLoader;
import io.JSONMovieLoaer;

public class MovieCollection implements CollectionManager<Movie> {
    private static MovieCollection instance = null;
    private Stack<Movie> collectionStack;
    private CollectionInfo collectionInfo;
    private int id = 1;

    public static MovieCollection getInstance() {
        if (instance == null) {
            instance = new MovieCollection();
        }
        return instance;
    }

    private MovieCollection() {
        collectionStack = new Stack<>();
        String path = "data/CollectionInfo.json";
        File file = new File(path);
        JSONCollectionInfoLoader cl = new JSONCollectionInfoLoader();
        if (file.exists()) {
            collectionInfo = cl.read(path);
        } else {
            collectionInfo = new CollectionInfo(ZonedDateTime.from(ZonedDateTime.now()));
            cl.write(path, collectionInfo);
        }
    }

    @Override
    public void save() {
        String path = "data/CollectionInfo.json";
        JSONCollectionInfoLoader cl = new JSONCollectionInfoLoader();
        collectionInfo = new CollectionInfo(ZonedDateTime.from(ZonedDateTime.now()));
        cl.write(path, collectionInfo);
    }

    // TODO - fix Args - args need a singleton
    public void setStartData() {
        String path = Args.getPathToFile();
        Loader<Movie> io = new JSONMovieLoaer<>();
        Movie[] loadMovies = io.read(path);
        MovieCollection.getInstance().setData(loadMovies);
        calcId();
    }

    private void calcId() {
        for(Movie m : collectionStack) {
            if(m.getId() > id) {
                id = m.getId() + 1;
            }
        }

    }

    public void clear() {
        collectionStack.clear();
    }

    public Stack<Movie> getData() {
        return collectionStack;
    }

    public CollectionInfo getInfo() {
        return this.collectionInfo;
    }

    public void setData(Movie[] movieData) {
        Collections.addAll(collectionStack, movieData);
    }

    public void pushElement(Movie t) {
        collectionStack.push(t);
    }

    public int getId() {
        return id++;
    }
}
