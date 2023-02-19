package logic;

import java.util.Stack;
import java.util.Date;
import java.time.Instant;
import java.util.Collections;

public class CollectionManager<T extends CollectionElement> {
    private Stack<T> collectionStack;
    private final Date initDate;
    
    public CollectionManager() {
        collectionStack = new Stack<>();
        initDate = Date.from(Instant.now());
    }

    public void clear() {
        collectionStack.clear();
    }

    public Stack<T> getData() {
        return collectionStack;
    }
    
    public Date getInitDate() {
        return initDate;
    }

    public void setData(T[] movieData) {
        Collections.addAll(collectionStack, movieData);
    }

    public void pushElement(T t) {
        collectionStack.push(t);
    }
}
