package logic;

import java.util.Stack;
import java.util.Date;

public interface CollectionManager<T extends CollectionElement> {

    void clear();

    Stack<T> getData();

    Date getInitDate();

    void setData(T[] movieData);

    void pushElement(T t);
}
