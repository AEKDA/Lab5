package io;

public abstract class Loader<T> {

    public abstract T read(String path);

    public abstract void write(String path, Object array);
}
