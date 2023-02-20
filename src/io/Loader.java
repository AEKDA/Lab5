package io;

public interface Loader<T> {

    T read(String path);

    void write(String path, Object array);
}
