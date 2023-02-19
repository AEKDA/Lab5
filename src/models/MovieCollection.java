package models;

import java.util.Stack;
import java.util.Date;
import java.time.Instant;
import java.util.Collections;

import logic.CollectionManager;

public class MovieCollection implements CollectionManager<Movie>{
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
