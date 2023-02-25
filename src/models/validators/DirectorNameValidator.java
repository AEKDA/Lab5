package models.validators;

public class DirectorNameValidator extends NameValidator {
    @Override
    public String getMessage() {
        return "Введите имя режиссера:";
    }
}
