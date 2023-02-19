package logic.instruction;


import logic.Instruction;
import models.MovieCollection;
import models.Movie;

public class AddInstruction implements Instruction {

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if(args.length != 1)
            throw new IllegalArgumentException("Error! input args incorrect!");
        Movie m = new Movie();
        m.getElement(System.in);

        MovieCollection.getInstance().pushElement(m);
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
