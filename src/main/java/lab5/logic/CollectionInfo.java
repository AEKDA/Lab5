package lab5.logic;

import java.time.ZonedDateTime;

/**
 * Класс предоставляющий информацию о коллекции
 */
public class CollectionInfo {
    private ZonedDateTime initDate;

    public CollectionInfo() {
        this.initDate = ZonedDateTime.now();
    }

    public CollectionInfo(ZonedDateTime date) {
        this.initDate = date;
    }

    /**
     * Метод, который возвращает время инициализации коллекции
     * 
     */
    public ZonedDateTime getDate() {
        return initDate;
    }
}
