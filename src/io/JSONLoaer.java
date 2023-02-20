package io;

import java.io.FileNotFoundException;
import java.time.ZonedDateTime;
import java.lang.reflect.Type;
import java.rmi.server.ObjID;
import java.time.format.DateTimeFormatter;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import logic.Args;

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

public abstract class JSONLoaer<T> implements Loader<T> {
    protected Gson gson;

    public JSONLoaer(Class<?> t) {
        GsonBuilder gsonBuilder = new GsonBuilder().setLenient().setPrettyPrinting()
                .registerTypeAdapter(ZonedDateTime.class, new GsonLocalDateTime());
        gson = gsonBuilder.create();
    }

    @Override
    public T[] read(String path) {
        try {
            FileReader f = new FileReader("beginData/test.json");
            JsonReader jr = gson.newJsonReader(f);
            JsonToken js = jr.peek();
            if (js == JsonToken.BEGIN_ARRAY) {
                Object[] o = new Object[1];
                o[0] = readArray();
                T[] tmp = (T[])o;

                return tmp;
            } else if (js == JsonToken.BEGIN_OBJECT) {
                return readObject();
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return null;
    }

    protected abstract T readArray();

    protected abstract T[] readObject();

    @Override
    public void write(String path, Object array) {
        try {
            PrintWriter printWriter = new PrintWriter(Args.getPathToFile());
            String json = gson.toJson(array);
            printWriter.write(json);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
