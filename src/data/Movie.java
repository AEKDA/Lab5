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
        id = hashCode();
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
    public Movie getElement(InputStream is) {
        Movie movie = new Movie();
        Scanner scan = new Scanner(is);
        if(is == System.in) {
            String input;
            
            do{System.out.println("Введите название фильма:"); input = scan.nextLine();}while(input.matches("\s"));
            movie.setName(input);

            String[] input_arr;
            do {
                System.out.println("Введите координаты в формате - x y:");
                input = scan.nextLine(); 
                input_arr = input.split(" +");
            } while(input_arr[0] == null || input_arr[1] == null || Double.parseDouble(input_arr[1]) > 777.0d);
            movie.setCoordinates(new Coordinates(Float.parseFloat(input_arr[0]), Double.parseDouble(input_arr[1])));
            
            do {
                System.out.println("Введите количество оскаров:");
                input = scan.nextLine();
            } while(input.isEmpty() || input == null || Long.parseLong(input) < 0);
            movie.setOscarCount(Long.parseLong(input));
            
            do { 
                System.out.println("Введите бюджет фильма:");
                input = scan.nextLine();
            } while(Float.parseFloat(input) > 0.0f);
            movie.setBudget(Float.parseFloat(input));

            do {
                System.out.println("Введите кассовые сборы фильма:");
                input = scan.nextLine(); MovieGenre.valueOf(input);
            } while(Double.parseDouble(input) > 0.0d);
            movie.setTotalBoxOffice(Float.parseFloat(input));

            boolean isDone;
            MovieGenre mg = null;
            do {
                System.out.println("Введите Жанр фильма из следующих: DRAMA, COMEDY, ADVENTURE, THRILLER, SCIENCE_FICTION:");
                input = scan.nextLine();
                isDone = false;
                try {
                    mg = MovieGenre.valueOf(input);
                    isDone = true;
                } catch(IllegalCallerException | NullPointerException e) {}
            } while(isDone);
            movie.setMovieGenre(mg);
        }
        else {

        }
        scan.close();

        return movie;
    }
    @Override
    public String toString() {
        return "{\n id = " +        Integer.toString(getId()) + ":\n  " + 
        "name = " +             getName() + "\n  " + 
        "coordinates = " +      this.coordinates.toString() + "\n  " + 
        "creation date = " +    this.creationDate.toString() + "\n  " +
        "Oscar Count = " +      Long.toString(getOscarCount()) +"\n  " +
        "Budget = " +           Float.toString(getBudget()) +"\n  " +
        "Total Box Office = " + Double.toString(getTotalBoxOffice()) + "\n  " +
        "Genre = " +            this.genre.toString() + "\n  " +
        "Director = " +         this.director.toString() + "\n}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.coordinates, this.creationDate, this.oscarsCount, this.budget, this.totalBoxOffice, this.genre, this.director);
    }
}