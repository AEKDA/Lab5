package lab5.models;

import java.util.Collections;
import java.util.Stack;
import java.time.ZonedDateTime;
import java.io.File;
import java.io.IOException;

import lab5.logic.CollectionManager;
import lab5.logic.FileManager;
import lab5.logic.CollectionInfo;
import lab5.io.CollectionLoader;
import lab5.io.JSONCollectionInfoLoader;
import lab5.io.JSONMovieLoaer;

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
        File file = new File(FileManager.get().getPathToInfo());
        JSONCollectionInfoLoader cl = new JSONCollectionInfoLoader();
        if (file.isFile() && file.canRead() && file.canWrite()) {
            collectionInfo = cl.read(FileManager.get().getPathToInfo());
        } else if (!file.isFile()) {
            collectionInfo = new CollectionInfo(ZonedDateTime.from(ZonedDateTime.now()));
            try {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdir();
                }
                file.createNewFile();
                cl.write(FileManager.get().getPathToInfo(), collectionInfo);
            } catch (IOException e) {
            }
        }
    }

    /**
     * Сохраняет данные о коллекции в файл
     */
    @Override
    public void save() {
        JSONCollectionInfoLoader cl = new JSONCollectionInfoLoader();
        collectionInfo = new CollectionInfo(ZonedDateTime.from(ZonedDateTime.now()));
        cl.write(FileManager.get().getPathToInfo(), collectionInfo);
    }

    /**
     * Устанавливает данные коллекции из файла, переданного в аргументы командной
     * строки
     */
    public void setStartData() {
        String path = FileManager.get().getPathToCollection();
        CollectionLoader<Movie> io = new JSONMovieLoaer();
        Movie[] loadMovies = io.read(path);
        if (loadMovies != null) {
            MovieCollection.getInstance().setData(loadMovies);
        }
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
