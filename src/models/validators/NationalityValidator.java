package models.validators;

import models.Country;

public class NationalityValidator implements Validator<Country> {
    private Country val;

    public Country getValue() {
        return val;
    }

    public String getMessage() {
        return "Введите страну, где родился режиссер: CHINA, INDIA, VATICAN, SOUTH_KOREA, NORTH_KOREA:";
    }

    public boolean check(String args) {
        try {
            val = Country.valueOf(args);
            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }
}