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

/**
 * Класс, реализующий интерфейс {@link logic.CollectionManager}
 * Экземпляр класса может быть только один, к нему можно получить доступ с
 * помощью {@link MovieCollection#getInstance()}
 * 
 */
public class MovieCollection implements CollectionManager<Movie> {
    private static MovieCollection instance = null;
    private Stack<Movie> collectionStack;
    private CollectionInfo collectionInfo;
    private int id = 1;

    /**
     * @return объект класса {@link MovieCollection}
     */
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

    /**
     * Сохраняет данные о коллекции в файл
     */
    @Override
    public void save() {
        String path = "data/CollectionInfo.json";
        JSONCollectionInfoLoader cl = new JSONCollectionInfoLoader();
        collectionInfo = new CollectionInfo(ZonedDateTime.from(ZonedDateTime.now()));
        cl.write(path, collectionInfo);
    }

    /**
     * Устанавливает данные коллекции из файла, переданного в аргументы командной
     * строки
     */
    // TODO - fix Args - args need a singleton
    public void setStartData() {
        String path = Args.getPathToFile();
        Loader<Movie> io = new JSONMovieLoaer();
        Movie[] loadMovies = io.read(path);
        MovieCollection.getInstance().setData(loadMovies);
    }

    private void calcId() {
        for (Movie m : collectionStack) {
            if (m.getId() > id) {
                id = m.getId() + 1;
            }
        }

    }

    /**
     * Очищает коллекцию
     */
    public void clear() {
        collectionStack.clear();
    }

    /**
     * Возвращает стек который содержит элементы типа {@link models.Movie}
     * 
     * @return {@link java.util.Stack}, который содержит элементы типа
     *         {@link models.Movie}
     */
    public Stack<Movie> getData() {
        return collectionStack;
    }

    /**
     * Возвращает данные о коллекции
     * 
     * @return {@link logic.CollectionInfo}
     */
    public CollectionInfo getInfo() {
        return this.collectionInfo;
    }

    /**
     * Добавляет в коллекцию элементы из массива
     * 
     * @param movieData Массив элементов типа {@link models.Movie}
     */
    public void setData(Movie[] movieData) {
        Collections.addAll(collectionStack, movieData);
        calcId();
    }

    /**
     * Добавляет элемент в коллекцию
     * 
     * @param movie Элемент, который будет добавлен в коллекцию
     */
    public void pushElement(Movie movie) {
        collectionStack.push(movie);
    }

    /**
     * Возвращает уникальный индификатор для коллекцииы
     * 
     * @return уникальный для этой коллекции id
     */
    public int getId() {
        return id++;
    }
}
