package lab5.io;

import com.google.gson.*;
import lab5.annotation.NotNull;
import com.google.gson.annotations.SerializedName;

import java.util.Set;
import java.util.HashSet;
import java.lang.reflect.Type;
import java.lang.reflect.Field;
import java.lang.annotation.Annotation;
import java.util.Map;
import java.time.ZonedDateTime;

public class JSONValidateDeserializer<T> implements JsonDeserializer<T> {
    private Set<String> notNullFields = null;

    private void init(Type type) {
        Class<?> cls = (Class<?>) type;
        Field[] fieldsArray = cls.getDeclaredFields();
        notNullFields = new HashSet<String>(fieldsArray.length);
        for (Field field : fieldsArray) {
            String name = field.getName().toLowerCase(); // учитываем возможность разных регистров
            Annotation[] annotations = field.getAnnotations(); // получаем все аннотации поля

            boolean isNotNull = false;
            for (Annotation annotation : annotations) {
                if (annotation instanceof NotNull) { // получаем все поля помеченные NotNull
                    isNotNull = true;
                } else if (annotation instanceof SerializedName) {
                    name = ((SerializedName) annotation).value().toLowerCase();
                }
            }
            if (isNotNull) {
                notNullFields.add(name);
            }
        }
    }

    @Override
    public T deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (notNullFields == null) {
            init(type); // Получаем структуру каждого класса через рефлексию только один раз для
                        // производительности
        }
        Set<Map.Entry<String, JsonElement>> entries = json.getAsJsonObject().entrySet();
        Set<String> keys = new HashSet<String>(entries.size());
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!entry.getValue().isJsonNull()) { // Игнорируем поля json, у которых значение null
                keys.add(entry.getKey().toLowerCase()); // собираем коллекцию всех имен полей в json
            }
        }
        if (!keys.containsAll(notNullFields)) {
            throw new JsonParseException("Parse error! The NotNull fields is absent in json for object:" + type);
        }
        GsonBuilder gsonBuilder = new GsonBuilder().setLenient().setPrettyPrinting()
        .registerTypeAdapter(ZonedDateTime.class, new GsonLocalDateTime());
        return gsonBuilder.create().fromJson(json, type); // запускаем стандартный механизм обработки GSON
    }
}
