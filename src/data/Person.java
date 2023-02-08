package data;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer height; //Поле не может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле не может быть null

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setEyeColor(Color color) {
        this.eyeColor = color;
    }

    public void setNationality(Country country) {
        this.nationality = country;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
