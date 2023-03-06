package lab5.io;

/**
 * Интерфейс, содержащий методы загрузки и записы элемента типа T
 */
public interface Loader<T> {

    T[] read(String path);

    void write(String path, Object array);
}
