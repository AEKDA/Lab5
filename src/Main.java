import java.util.Stack;
import data.Movie;
import fileLoader.Loader;
import logic.CollectionManager;
import logic.InstructionListener;

public class Main {

    public static void main(String[] args) 
    {    
        if(args.length != 1) {
            System.err.println("Error! There must be one argument");
            return;
        }
        Loader<Movie> loader = new Loader<>();
        loader.readJSONFile(args[0]);

        CollectionManager collectionManager = new CollectionManager();
        collectionManager.setData(loader.getData());

        InstructionListener commandListener = new InstructionListener(collectionManager);
        commandListener.start();
    }

}