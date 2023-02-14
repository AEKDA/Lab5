import data.Color;
import data.Coordinates;
import data.Country;
import data.Location;
import data.Movie;
import data.MovieGenre;
import data.Person;
import loader.JSONLoaer;
import loader.Loader;
import logic.CollectionManager;
import logic.InstructionListener;

public class Main {

    public static void main(String[] args) 
    {    
        // if(args.length != 1) {
        //      System.err.println("Error! You didn't specify the path to the file");
        //      return;
        // }
        // Loader<Movie> loader = new JSONLoaer<>();
        // loader.read(args[0]);

        // CollectionManager<Movie> collectionManager = new CollectionManager<>();
        // // collectionManager.setData(loader.getData());

        // InstructionListener instructionListener = new InstructionListener(collectionManager);


        // instructionListener.start(System.in);
        Movie m = new Movie();
        m.setCoordinates(new Coordinates(1234.4f, 123.5d));
        m.setMovieGenre(MovieGenre.DRAMA);
        Person p = new Person();
        p.setEyeColor(Color.BROWN);
        p.setHeight(123);
        p.setLocation(new Location(132,133.2d,432.4f, "Russia"));
        p.setName("null");
        p.setNationality(Country.CHINA);
        m.setDirector(p);
        System.out.println(m.toString());
    }

}