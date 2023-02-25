package models.validators;

public class LocationNameValidator extends NameValidator {
    @Override
    public String getMessage() {
        return "Введите название локации: ";
    }
}
