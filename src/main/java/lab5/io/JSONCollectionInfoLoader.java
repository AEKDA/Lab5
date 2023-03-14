package lab5.io;

import java.time.ZonedDateTime;
import java.io.IOException;
import java.io.File;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ObjectMapper;

import lab5.logic.CollectionInfo;

/**
 * Класс, абстрагирующий парсер json'а, с помощью которго можно считать
 * {@link lab5.logic.CollectionInfo}
 */
public class JSONCollectionInfoLoader {
    private ObjectMapper objectMapper;

    public JSONCollectionInfoLoader() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(ZonedDateTime.class, new JaksonZonedDateTimeDeserializer());
        simpleModule.addSerializer(ZonedDateTime.class, new JaksonZonedDateTimeSerializer());
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
    }

    /**
     * 
     * @param path путь до файла, содержащего данные о коллекции
     * @return данные о коллекции считанные из файла
     */
    public CollectionInfo read(String path) {
        try {
            File file = new File(path);
            if (file.isFile() && file.canRead()) {
                return objectMapper.readValue(new File(path), CollectionInfo.class);
            }
        } catch (IOException e) {
        }
        return new CollectionInfo();
    }

    /**
     * Метод, который записывает в в файл данные из объекта типа
     * {@link lab5.logic.CollectionInfo}
     * 
     * @param path  путь до файла
     * @param array объект, который будет серриализован
     */
    public void write(String path, CollectionInfo val) {
        try {
            File file = new File(path);
            if (file.isFile() && file.canWrite()) {
                objectMapper.writeValue(new File(path), val);
            }
        } catch (IOException e) {
            Logger.get().writeLine(e.getMessage());
        }
    }
}
