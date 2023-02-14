package data;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Scanner;

import logic.CollectionElement;
import java.util.Objects;

public class Movie implements CollectionElement {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long oscarsCount; //Значение поля должно быть больше 0
    private float budget; //Значение поля должно быть больше 0
    private double totalBoxOffice; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле не может быть null
    private Person director; //Поле может быть null

    {
        creationDate = ZonedDateTime.now();
    }

    public void setName(String name) throws IllegalArgumentException {
        if(name == null) 
            throw new IllegalArgumentException("Error! Name is empty!");
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCoordinates(Coordinates coordinates) throws IllegalArgumentException{
        if(coordinates == null) 
            throw new IllegalArgumentException("Error! coordinates is empty!");
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setOscarCount(long oscarsCount) throws IllegalArgumentException{
        if(oscarsCount < 1)
            throw new IllegalArgumentException("Error! oscar count must be greater than zero");
        this.oscarsCount = oscarsCount;
    }

    public long getOscarCount() {
        return this.oscarsCount;
    }

    public void setId(int id) throws IllegalArgumentException{
        if(id < 1)
            throw new IllegalArgumentException("Error! id must be greater than zero");
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
    
    public java.time.ZonedDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setBudget(float budget) throws IllegalArgumentException{
        if(budget < 1)
            throw new IllegalArgumentException("Error! budget must be greater than zero");
        this.budget = budget;
    }

    public float getBudget()  {
        return this.budget;
    }

    public void setMovieGenre(MovieGenre genre) throws IllegalArgumentException{
        if(genre == null) 
            throw new IllegalArgumentException("Error! genre must not be a zero value");
        this.genre = genre;
    }

    public MovieGenre getMovieGenre() {
        return genre;
    }

    public void setTotalBoxOffice(double totalBoxOffice) throws IllegalArgumentException {
        if(totalBoxOffice < 1)
            throw new IllegalArgumentException("Error! total box office must be greater than zero");
        this.totalBoxOffice = totalBoxOffice;
    }

    public double getTotalBoxOffice() {
        return this.totalBoxOffice;
    }

    public void setDirector(Person direction) throws IllegalArgumentException {
        if(direction == null) 
            throw new IllegalArgumentException("Error! direction must not be a zero value");
        this.director = direction;
    }

    public Person getDirector() {
        return director;
    }
    @Override
    public Movie getElementFromFile(InputStream is) {
        Scanner scan = new Scanner(is);
        String s = scan.nextLine();
        Movie movie = new Movie();

        return movie;
    }
    @Override
    public Movie getElementFromConsole(InputStream is) {
        Scanner scan = new Scanner(is);
        String s = scan.nextLine();
        Movie movie = new Movie();

        return movie;
    }
    @Override
    public String toString() {
        return Integer.toString(getId()) + ":\n  " + 
        getName() + "\n  " + 
        this.coordinates.toString() + "\n  " + 
        this.creationDate.toString() + "\n  " +
        Long.toString(getOscarCount()) +"\n  " +
        Float.toString(getBudget()) +"\n  " +
        Double.toString(getTotalBoxOffice()) + "\n  " +
        this.genre.toString() + "\n  " +
        this.director.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.coordinates, this.creationDate, this.oscarsCount, this.budget, this.totalBoxOffice, this.genre, this.director);
    }
}