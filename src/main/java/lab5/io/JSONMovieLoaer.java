package lab5.io;

import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import lab5.models.Movie;

/**
 * Класс реализующий загрузку и записать из json файла в коллекцию содержащую
 * элементы типа{@link models.Movie}
 */
public class JSONMovieLoaer implements Loader<Movie> {
    protected Gson gson;

    public JSONMovieLoaer() {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(ZonedDateTime.class, new GsonLocalDateTime())
                .registerTypeAdapter(Movie.class, new JSONValidateDeserializer<Movie>());
        gson = gsonBuilder.create();
    }

    /**
     * @param path Путь до json файла
     * @return Массив элементов типа Movie
     */
    @Override
    public Movie[] read(String path) {
        try {
            FileReader f = new FileReader(path);
            JsonReader jr = gson.newJsonReader(f);
            JsonToken js = jr.peek();
            if (js == JsonToken.BEGIN_OBJECT) {
                Movie[] o = new Movie[1];
                o[0] = gson.fromJson(jr, Movie.class);
                return o;
            } else if (js == JsonToken.BEGIN_ARRAY) {
                return (Movie[]) gson.fromJson(jr, Movie[].class);
            }
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * @param path  путь до файла
     * @param array Массив из которого будут взяты элементы типа Movie
     */
    @Override
    public void write(String path, Object array) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            String json = gson.toJson(array);
            printWriter.write(json);
            printWriter.close();
        } catch (FileNotFoundException e) {
            Logger.get().writeLine(e.getMessage());
        }

    }

}