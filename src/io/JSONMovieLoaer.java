package io;

import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import logic.CollectionElement;
import models.Movie;

class GsonLocalDateTime implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {

    @Override
    public ZonedDateTime deserialize(JsonElement jsonElement, Type type,
            JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String ldtString = jsonElement.getAsString();
        return ZonedDateTime.parse(ldtString, DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    @Override
    public JsonElement serialize(ZonedDateTime localDateTime, Type type,
            JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
    }
}

public class JSONMovieLoaer<T extends CollectionElement> implements Loader<T> {
    protected Gson gson;

    public JSONMovieLoaer() {
        GsonBuilder gsonBuilder = new GsonBuilder().setLenient().setPrettyPrinting()
                .registerTypeAdapter(ZonedDateTime.class, new GsonLocalDateTime());
        gson = gsonBuilder.create();
    }

    @SuppressWarnings("all")
    @Override
    public T[] read(String path) {
        try {
            FileReader f = new FileReader(path);
            JsonReader jr = gson.newJsonReader(f);
            JsonToken js = jr.peek();
            if (js == JsonToken.BEGIN_OBJECT) {
                Object[] o = new Object[1];
                o[0] = gson.fromJson(jr, Movie.class);
                return (T[])o;
            } else if (js == JsonToken.BEGIN_ARRAY) {
                return (T[]) gson.fromJson(jr, Movie[].class);
            }
        } catch (FileNotFoundException e) {
            Logger.get().writeLine(e.getMessage());
        } catch (IOException e) {
            Logger.get().writeLine(e.getMessage());
        }
        return null;
    }

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
