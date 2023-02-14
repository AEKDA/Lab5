package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;

import java.util.function.Predicate;

import data.Movie;

public class Remove_by_idInstruction implements Instruction {
    private CollectionManager<Movie> collectionManager;
    
    public Remove_by_idInstruction(CollectionManager<Movie> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if(args.length != 2) {
            throw new IllegalArgumentException("");
        }
        collectionManager.getData().removeIf(new Predicate<Movie>() {
            public boolean test(Movie m) {
                return m.getId() == Integer.parseInt(args[1]);
            }
        });
    }
    @Override 
    public String getName() {
        return "remove_by_id";
    }
    @Override
    public String about() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}
