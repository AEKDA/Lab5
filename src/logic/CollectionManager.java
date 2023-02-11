package logic;

import java.util.Stack;
import data.Movie;

public class CollectionManager {
    Stack<Movie> collectionStack;
    
    public CollectionManager() {
        collectionStack = new Stack<>();
    }

    public void clear() {
        collectionStack.clear();
    }
}
