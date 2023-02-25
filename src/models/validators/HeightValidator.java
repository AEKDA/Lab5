package models.validators;

public class HeightValidator implements Validator<Integer> {
    private Integer val;

    public Integer getValue() {
        return val;
    }

    public String getMessage() {
        return "Введите рост режиссера";
    }

    public boolean check(String args) {
        if(args == null || args.isEmpty()) {
            return false;
        }
        try {
            val = Integer.parseInt(args);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
