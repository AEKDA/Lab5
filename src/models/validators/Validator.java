package models.validators;

public interface Validator<T> {
    boolean check(String args);
    String getMessage();
    T getValue();
}
