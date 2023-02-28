package io;

import java.time.ZonedDateTime;
import java.lang.reflect.Type;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

import logic.CollectionInfo;

import com.google.gson.*;
import com.google.gson.stream.*;

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

/**
 * Класс, абстрагирующий парсер json'а, с помощью которго можно считать
 * {@link logic.CollectionInfo}
 */
public class JSONCollectionInfoLoader {
    private Gson gson;

    public JSONCollectionInfoLoader() {
        GsonBuilder gsonBuilder = new GsonBuilder().setLenient().setPrettyPrinting()
                .registerTypeAdapter(ZonedDateTime.class, new GsonLocalDateTime());
        gson = gsonBuilder.create();
    }

    /**
     * 
     * @param path путь до файла, содержащего данные о коллекции
     * @return данные о коллекции считанные из файла
     */
    public CollectionInfo read(String path) {
        try {
            FileReader f = new FileReader(path);
            JsonReader jr = gson.newJsonReader(f);
            return gson.fromJson(jr, CollectionInfo.class);
        } catch (FileNotFoundException e) {
            Logger.get().writeLine(e.getMessage());
        }
        return null;
    }

    /**
     * Метод, который записывает в в файл данные из объекта типа {@link logic.CollectionInfo}
     * @param path  путь до файла
     * @param array объект, который будет серриализован
     */
    public void write(String path, CollectionInfo array) {
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
