package logic.instruction;

import logic.Instruction;
import logic.CollectionManager;
import data.Movie;


public class Insert_adInstruction implements Instruction {
    private CollectionManager<Movie> collectionManager;
    public Insert_adInstruction(CollectionManager<Movie> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if(args.length != 2) {throw new IllegalArgumentException("Error! ...");}
        Movie m = new Movie();
        m.getElement(System.in);
        collectionManager.getData().insertElementAt(m, Integer.parseInt(args[1]));
    }
    @Override 
    public String getName() {
        return "insert_at";
    }
    @Override
    public String about() {
        return "добавить новый элемент в заданную позицию";
    }
}
