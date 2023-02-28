package models;

import java.time.ZonedDateTime;

import java.util.Objects;

import io.Logger;
import logic.CollectionElement;
import models.validators.*;
import io.Cin;

public class Movie implements CollectionElement {
    private int id; // Значение поля должно быть больше 0, Значение этого поля должно быть
                    // уникальным, Значение этого поля должно генерироваться автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private ZonedDateTime creationDate; // Поле не может быть null, Значение этого поля должно генерироваться
                                                  // автоматически
    private long oscarsCount; // Значение поля должно быть больше 0
    private float budget; // Значение поля должно быть больше 0
    private double totalBoxOffice; // Значение поля должно быть больше 0
    private MovieGenre genre; // Поле не может быть null
    private Person director; // Поле может быть null

    {
        creationDate = ZonedDateTime.now();
        id = genId();
    }

    private int genId() {
        return (int)MovieCollection.getInstance().getId();
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null)
            throw new IllegalArgumentException("Error! Name is empty!");
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCoordinates(Coordinates coordinates) throws IllegalArgumentException {
        if (coordinates == null)
            throw new IllegalArgumentException("Error! coordinates is empty!");
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setOscarCount(long oscarsCount) throws IllegalArgumentException {
        if (oscarsCount < 1)
            throw new IllegalArgumentException("Error! oscar count must be greater than zero");
        this.oscarsCount = oscarsCount;
    }

    public long getOscarCount() {
        return this.oscarsCount;
    }

    public void setId(int id) throws IllegalArgumentException {
        if (id < 1)
            throw new IllegalArgumentException("Error! id must be greater than zero");
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return this.creationDate;
    }

    public void setBudget(float budget) throws IllegalArgumentException {
        if (budget < 1)
            throw new IllegalArgumentException("Error! budget must be greater than zero");
        this.budget = budget;
    }

    public float getBudget() {
        return this.budget;
    }

    public void setMovieGenre(MovieGenre genre) throws IllegalArgumentException {
        if (genre == null)
            throw new IllegalArgumentException("Error! genre must not be a zero value");
        this.genre = genre;
    }

    public MovieGenre getMovieGenre() {
        return genre;
    }

    public void setTotalBoxOffice(double totalBoxOffice) throws IllegalArgumentException {
        if (totalBoxOffice < 1)
            throw new IllegalArgumentException("Error! total box office must be greater than zero");
        this.totalBoxOffice = totalBoxOffice;
    }

    public double getTotalBoxOffice() {
        return this.totalBoxOffice;
    }

    public void setDirector(Person direction) throws IllegalArgumentException {
        if (direction == null)
            throw new IllegalArgumentException("Error! direction must not be a zero value");
        this.director = direction;
    }

    public Person getDirector() {
        return director;
    }

    @Override
    public void getElement(Cin scan) {
        name = get(new NameValidator(), scan);
        coordinates = get(new CoordinatesValidator(), scan);
        oscarsCount = get(new OscarCountValidator(), scan);
        budget = get(new BudgetValidator(), scan);
        totalBoxOffice = get(new TotalBoxOfficeValidator(), scan);
        genre = get(new MovieGenreValidator(), scan);

        Person p = new Person();
        p.setName(get(new DirectorNameValidator(), scan));
        p.setHeight(get(new HeightValidator(), scan));
        p.setEyeColor(get(new ColorValidator(), scan));
        p.setNationality(get(new NationalityValidator(), scan));

        Location l = new Location();
        l.setCoordinates(get(new LocationCoordsValidator(), scan));
        l.setName(get(new LocationNameValidator(), scan));
        p.setLocation(l);
        director = p;

    }

    private <T> T get(Validator<T> validator, Cin scan) {
        String args = null;
        do {
            if (Cin.peek().getType() == Cin.Type.STD) {
                Logger.get().writeLine(validator.getMessage());
                args = scan.getScanner().nextLine();
            } else {
                if (scan.getScanner().hasNextLine()) {
                    args = scan.getScanner().nextLine();
                }
            }
        } while (!validator.check(args));
        return validator.getValue();
    }

    @Override
    public String toString() {
        return "{\n id = " + Integer.toString(getId()) + ":\n  " +
                "name = " + getName() + "\n  " +
                "coordinates = " + this.coordinates.toString() + "\n  " +
                "creation date = " + this.creationDate.toString() + "\n  " +
                "Oscar Count = " + Long.toString(getOscarCount()) + "\n  " +
                "Budget = " + Float.toString(getBudget()) + "\n  " +
                "Total Box Office = " + Double.toString(getTotalBoxOffice()) + "\n  " +
                "Genre = " + this.genre.toString() + "\n  " +
                "Director = " + this.director.toString() + "\n}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.coordinates, this.creationDate, this.oscarsCount, this.budget,
                this.totalBoxOffice, this.genre, this.director);
    }
}