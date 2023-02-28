package logic;

import java.util.Stack;

/**
 * Интерфейс, который предоставляет абстрагированные методы для работы с коллекциями
 */
public interface CollectionManager<T extends CollectionElement> {

    void clear();

    Stack<T> getData();

    CollectionInfo getInfo();

    void setData(T[] movieData);

    void pushElement(T t);

    void save();

    int getId();
}
