package logic;

import java.time.ZonedDateTime;


public class CollectionInfo {
    private final ZonedDateTime initDate;

    public CollectionInfo(ZonedDateTime date) {
        this.initDate = date;
    }

    public ZonedDateTime getDate() {
        return initDate;
    }
}
