import java.util.Stack;
import data.Movie;
import fileLoader.Loader;
import collectionManager.CollectionManager;

public class Main {

    public static void main(String[] argv) 
    {
        Loader<Stack<Movie>> loader = new Loader<Stack<Movie>>();
        loader.readJSONFile(argv);

        CollectionManager collectionManager = new CollectionManager();
        collectionManager.setData(loader.setData());

        CommandListener commandListener = new CommandListener(collectionManager);
        commandListener.start();
    }

}