package logic.instruction;

import data.Movie;
import logic.CollectionManager;
import logic.Instruction;

public class Filter_contains_nameInstruction implements Instruction {
    private CollectionManager<Movie> collectionManager;
    public Filter_contains_nameInstruction(CollectionManager<Movie> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if(args.length < 2) {
            throw new IllegalArgumentException("Error! The arguments are not correct");
        }
        for(Movie movie: collectionManager.getData()) {
            if(movie.getName().contains(args[1])) {
                System.out.println(movie.toString());
            }
        }
    }
    @Override 
    public String getName() {
        return "filter_contains_name";
    }
    @Override
    public String about() {
        return "вывести элементы, значение поля name которых содержит заданную подстроку";
    }
}
