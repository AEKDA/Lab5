package logic.instruction;

import exception.IncorrectArgumentException;
import logic.Instruction;
import logic.CollectionManager;
import data.Movie;

public class AddInstruction implements Instruction {
    CollectionManager<Movie> collectionManager;
    public AddInstruction(CollectionManager<Movie> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) throws IncorrectArgumentException {
        if(args.length != 1)
            throw new IncorrectArgumentException("Error! input args incorrect!");
        Movie m = new Movie();
        m.getElement(System.in);

        collectionManager.pushElement(m);
    }
    @Override 
    public String getName() {
        return "add";
    }
    @Override
    public String about() {
        return "добавить новый элемент в коллекцию";
    }
}
