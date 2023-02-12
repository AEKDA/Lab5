package logic;

import java.util.Stack;

public class CollectionManager<T> {
    private Stack<T> collectionStack;
    
    public CollectionManager() {
        collectionStack = new Stack<>();
    }

    public void clear() {
        collectionStack.clear();
    }

    public Stack<T> getData() {
        return collectionStack;
    }

    public void setData(Stack<T> movieData) {
        collectionStack = movieData;
    }

    public void pushElement(T movie) {
        collectionStack.push(movie);
    }
}
