import java.util.Stack;
import data.Movie;
import fileLoader.Loader;
import collectionManager.CollectionManager;

public class Main {

    public static void main(String[] argv) 
    {
        Loader<Stack<Movie>> loader = new Loader<Stack<Movie>>();

        CollectionManager collectionManager = new CollectionManager();
        collectionManager.getCommand();
    }

}