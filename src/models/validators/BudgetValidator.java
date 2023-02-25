package models.validators;

public class BudgetValidator implements Validator<Float> {
    private float val;

    @Override
    public boolean check(String args) {
        try {
            val = Float.parseFloat(args);
            if (args.isEmpty() || val <= 0)
                return false;
            return true;
        } catch (NullPointerException | NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getMessage() {
        return "Введите бюджет фильма: ";
    }

    @Override
    public Float getValue() {
        return val;
    }
}
