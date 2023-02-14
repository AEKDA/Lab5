package logic.instruction;

import java.util.Collections;
import java.util.Comparator;

import logic.CollectionManager;
import data.Movie;
import logic.Instruction;

public class Print_descendingInstruction implements Instruction {
    private CollectionManager<Movie> collectionManager;
    public Print_descendingInstruction(CollectionManager<Movie> collectionManager) {
        this.collectionManager = collectionManager;
    }
    
    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if(args.length != 1) {
            throw new IllegalArgumentException("Error! Argument of Instruction incorrect");
        }
        Collections.sort(collectionManager.getData(), new Comparator<Movie>() {
            public int compare(Movie t1, Movie t2) {
                return t1.getName().compareTo(t2.getName()) * -1;
            }
        });
    }
    
    @Override 
    public String getName() {
        return "print_descending";
    }
    @Override
    public String about() {
        return "вывести элементы коллекции в порядке убывания";
    }
}
