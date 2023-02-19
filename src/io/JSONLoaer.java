package io;

import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.io.FileReader;


import com.google.gson.*;

import models.Movie;

class GsonLocalDateTime implements JsonSerializer<ZonedDateTime>, JsonDeserializer<ZonedDateTime> {

    @Override
    public ZonedDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String ldtString = jsonElement.getAsString();
        return ZonedDateTime.parse(ldtString,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public JsonElement serialize(ZonedDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}

public class JSONLoaer<T> extends Loader<T> {
    Class<?> typeClass;
    Gson gson;

    public JSONLoaer(Class<?> t) {
        typeClass = t;
        GsonBuilder gsonBuilder = new GsonBuilder().setLenient().setPrettyPrinting().registerTypeAdapter(ZonedDateTime.class, new GsonLocalDateTime());
        gson = gsonBuilder.create();
    }
    @Override
    public T read(String path) {
        try {
            // BaseReader bs;
            // bs = new BaseReader(path);
            // String json = bs.read();
            // System.out.println(json);
            FileReader fr = new FileReader(path);
            return (T)gson.fromJson(fr, Movie[].class);
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
    @Override
    public void write(String path, T array) {
        
    }

}
