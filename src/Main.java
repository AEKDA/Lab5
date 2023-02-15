import java.util.Scanner;

import data.Movie;
import loader.JSONLoaer;
import loader.Loader;
import logic.CollectionManager;
import logic.InstructionListener;

public class Main {

    public static void main(String[] args) 
    {    
        Scanner in = new Scanner(System.in);
        if(args.length != 1) {
             System.err.println("Error! You didn't specify the path to the file");
             System.out.println("Entered File path: ");
             args = new String[1];
             args[0] = in.nextLine();
             in.close();
        }

        Loader<Movie> loader = new JSONLoaer<>();
        loader.read(args[0]);

        CollectionManager<Movie> collectionManager = new CollectionManager<>();
        // collectionManager.setData(loader.getData());

        InstructionListener instructionListener = new InstructionListener(collectionManager);


        instructionListener.start(System.in);
    }

}