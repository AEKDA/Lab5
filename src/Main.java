import java.util.Scanner;

import data.Movie;
import loader.JSONLoaer;
import loader.Loader;
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

        Loader<Movie[]> loader = new JSONLoaer<>(Movie[].class);
        Movie[][] m = loader.read(args[0]);
        System.out.println(m);

        CollectionManager<Movie> collectionManager = new CollectionManager<>();

        InstructionListener instructionListener = new InstructionListener(collectionManager);


        instructionListener.start(System.in);
    }

}