package data;

public class Movie {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long oscarsCount; //Значение поля должно быть больше 0
    private float budget; //Значение поля должно быть больше 0
    private double totalBoxOffice; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле не может быть null
    private Person director; //Поле может быть null

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setOscarCount(long oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public long getOscarCount() {
        return this.oscarsCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int setId() {
        return this.id;
    }
    
    public java.time.ZonedDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getBudget() {
        return this.budget;
    }

    public void setMovieGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public MovieGenre getMovieGenre() {
        return genre;
    }

    public void setTotalBoxOffice(double totalBoxOffice) {
        this.totalBoxOffice = totalBoxOffice;
    }

    public double getTotalBoxOffice() {
        return this.totalBoxOffice;
    }

    public void setDirector(Person direction) {
        this.director = direction;
    }

    public Person getDirector() {
        return director;
    }
}