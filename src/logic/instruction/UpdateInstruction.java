package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;

import data.Movie;

public class UpdateInstruction implements Instruction {
    private CollectionManager<Movie> collectionManager;
    public UpdateInstruction(CollectionManager<Movie> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        Movie m = new Movie();
        m.getElement(System.in);

        for(Movie movie: collectionManager.getData()) {
            if(movie.getId() == m.getId()) {
                movie = m;
                break;
            }
        }
    }
    @Override 
    public String getName() {
        return "update";
    }
    @Override
    public String about() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
