package models.validators;

public class TotalBoxOfficeValidator implements Validator<Double> {
    private Double val;

    public boolean check(String args) {
        try {
            val = Double.parseDouble(args);
            if (args.isEmpty() || val <= 0)
                return false;
            return true;
        } catch (NullPointerException | NumberFormatException e) {
            return false;
        }
    }

    public String getMessage() {
        return "Введите кассовые сборы фильма:";
    }

    public Double getValue() {
        return val;
    }
}
