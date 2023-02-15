package logic.instruction;

import data.Movie;
import logic.CollectionManager;
import logic.Instruction;

public class Add_if_maxInstruction implements Instruction {
    private CollectionManager<Movie> collectionManager;

    public Add_if_maxInstruction(CollectionManager<Movie> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        Movie m = new Movie();
        m.getElement(System.in);
        for(Movie movie: this.collectionManager.getData()) {
            if(movie.getTotalBoxOffice() >= m.getTotalBoxOffice()) {
                return;
            }
        }
        collectionManager.pushElement(m);
    }
    @Override 
    public String getName() {
        return "add_if_max";
    }
    @Override
    public String about() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }
}
