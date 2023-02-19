import java.util.Scanner;

import models.Movie;
import models.MovieCollection;
import io.JSONLoaer;
import io.Loader;
import io.Logger;
import logic.CollectionManager;
import logic.InstructionListener;


//TODO: Create CollectionManager Interface
//TODO: Create Singleton MovieManager



public class Main {

    public static void main(String[] args) 
    {// TODO: fix system.out
        if(args.length != 1) {
            System.err.println("Error! You didn't specify the path to the file");
            System.out.println("Entered File path: ");
            args = new String[1];
            Scanner in = new Scanner(System.in);
            args[0] = in.nextLine();
        }

        Logger logger = new Logger(System.in, System.out);

        Loader<Movie[]> io = new JSONLoaer<>(Movie[].class);
        Movie[] loadMovies = io.read(args[0]);

        MovieCollection.getInstance().setData(loadMovies);

        InstructionListener instructionListener = new InstructionListener();

        instructionListener.start(System.in);
    }

}