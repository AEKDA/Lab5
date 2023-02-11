import data.Movie;
import fileLoader.Loader;
import logic.CollectionManager;
import logic.InstructionListener;

public class Main {

    public static void main(String[] args) 
    {    
        // if(args.length != 1) {
        //     System.err.println("Error! You didn't specify the path to the file");
        //     return;
        // }
        // Loader<Movie> loader = new Loader<>();
        // loader.readJSONFile(args[0]);

        CollectionManager collectionManager = new CollectionManager();
        // collectionManager.setData(loader.getData());

        InstructionListener instructionListener = new InstructionListener(collectionManager);
        instructionListener.start();
    }

}