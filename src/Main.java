import java.util.Scanner;

import data.Movie;
import io.JSONLoaer;
import io.Loader;
import logic.CollectionManager;
import logic.InstructionListener;



public class Main {

    public static void main(String[] args) 
    {
        if(args.length != 1) {
            System.err.println("Error! You didn't specify the path to the file");
            System.out.println("Entered File path: ");
            args = new String[1];
            Scanner in = new Scanner(System.in);
            args[0] = in.nextLine();
        }

        Loader<Movie[]> io = new JSONLoaer<>(Movie[].class);
        Movie[] loadMovies = io.read(args[0]);

        CollectionManager<Movie> collectionManager = new CollectionManager<>();

        collectionManager.setData(loadMovies);

        InstructionListener instructionListener = new InstructionListener(collectionManager);


        instructionListener.start(System.in);
    }

}