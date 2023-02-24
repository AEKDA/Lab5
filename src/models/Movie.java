package models;

import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.Objects;

import io.Logger;
import logic.CollectionElement;

@FunctionalInterface
interface Check {
    void field(Object... args);
}

public class Movie implements CollectionElement {
    private int id; // Значение поля должно быть больше 0, Значение этого поля должно быть
                    // уникальным, Значение этого поля должно генерироваться автоматически
    private String name; // Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; // Поле не может быть null
    private java.time.ZonedDateTime creationDate; // Поле не может быть null, Значение этого поля должно генерироваться
                                                  // автоматически
    private long oscarsCount; // Значение поля должно быть больше 0
    private float budget; // Значение поля должно быть больше 0
    private double totalBoxOffice; // Значение поля должно быть больше 0
    private MovieGenre genre; // Поле не может быть null
    private Person director; // Поле может быть null

    {
        creationDate = ZonedDateTime.now();
        id = hashCode();
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
    public void getElement(InputStream is) {
        // TODO: fix system.out
        Scanner scan = new Scanner(is);
        if (is == System.in) {
            String input;

            do {
                Logger.get().writeLine("Введите название фильма: ");
                input = scan.nextLine();
            } while (input.isEmpty() || input == null);
            this.setName(input);

            String[] input_arr;
            do {
                Logger.get().writeLine("Введите координаты в формате - x y:");
                input = scan.nextLine();
                input_arr = input.split(" +");
            } while (input_arr[0] == null || input_arr[1] == null || Double.parseDouble(input_arr[1]) > 777.0d);
            this.setCoordinates(new Coordinates(Float.parseFloat(input_arr[0]), Double.parseDouble(input_arr[1])));

            do {
                Logger.get().writeLine("Введите количество оскаров:");
                input = scan.nextLine();
            } while (input.isEmpty() || input == null || Long.parseLong(input) < 0);
            this.setOscarCount(Long.parseLong(input));

            do {
                Logger.get().writeLine("Введите бюджет фильма:");
                input = scan.nextLine();
            } while (input.isEmpty() && Float.parseFloat(input) <= 0.0f);
            this.setBudget(Float.parseFloat(input));

            boolean isDone = false;
            do {
                Logger.get().writeLine("Введите кассовые сборы фильма: ");
                input = scan.nextLine();
                try {
                    this.setTotalBoxOffice(Float.parseFloat(input));
                    isDone = true;
                } catch (IllegalArgumentException e) {
                }
            } while (!isDone);

            // set("Введите кассовые сборы фильма: ", this::setTotalBoxOffice);

            isDone = false;
            MovieGenre mg = null;
            do {
                Logger.get().writeLine(
                        "Введите Жанр фильма из следующих: DRAMA, COMEDY, ADVENTURE, THRILLER, SCIENCE_FICTION:");
                input = scan.nextLine();
                isDone = false;
                try {
                    mg = MovieGenre.valueOf(input);
                    isDone = true;
                } catch (IllegalCallerException | NullPointerException e) {
                }
            } while (!isDone);
            this.setMovieGenre(mg);

            Person p = new Person();
            do {
                Logger.get().writeLine("Введите имя режиссера:");
                input = scan.nextLine();
            } while (input.matches("\n"));
            p.setName(input);

            do {
                Logger.get().writeLine("Введите рост режиссера:");
                input = scan.nextLine();
            } while (input.isEmpty() && Integer.parseInt(input) <= 0);
            p.setHeight(Integer.valueOf(input));

            isDone = false;
            Color c = null;
            do {
                Logger.get().writeLine("Введите цвет глаз из следующих: RED,YELLOW, BROWN:");
                input = scan.nextLine();
                isDone = false;
                try {
                    c = Color.valueOf(input);
                    isDone = true;
                } catch (IllegalCallerException | NullPointerException e) {
                }
            } while (!isDone);
            p.setEyeColor(c);

            isDone = false;
            Country country = null;
            do {
                Logger.get().writeLine(
                        "Введите страну, где родился режиссер: CHINA, INDIA, VATICAN, SOUTH_KOREA, NORTH_KOREA:");
                input = scan.nextLine();
                isDone = false;
                try {
                    country = Country.valueOf(input);
                    isDone = true;
                } catch (IllegalCallerException | NullPointerException e) {
                }
            } while (!isDone);
            p.setNationality(country);

            do {
                Logger.get().writeLine("Введите локацию в формате - x y z name:");
                input = scan.nextLine();
                input_arr = input.split(" +");
                isDone = false;
                try {
                    p.setLocation(new Location(Long.valueOf(input_arr[0]), Double.valueOf(input_arr[1]),
                            Float.valueOf(input_arr[2]), input_arr[3]));
                    isDone = true;
                } catch (IllegalArgumentException e) {
                }
            } while (input_arr[3].matches("\n") && !isDone);
            this.setDirector(p);
        } else {

        }

    }

    // TODO: fix system.out
    void set(String message, Check c, Scanner scan) {
        int count = c.getClass().getDeclaredMethods()[0].getParameterCount();
        boolean isDone = false;
        do {
            try {
                Logger.get().writeLine(message);
                if (count == 0) {
                    c.field();
                } else if (count > 1) {
                    String input = scan.nextLine();
                }
                isDone = true;
            } catch (IllegalArgumentException | NullPointerException e) {
                Logger.get().writeLine(e.getMessage());
            }
        } while (!isDone);
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