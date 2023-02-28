package logic;

import java.time.ZonedDateTime;

/**
 * Класс предоставляющий информацию о коллекции
 */
public class CollectionInfo {
    private final ZonedDateTime initDate;

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
