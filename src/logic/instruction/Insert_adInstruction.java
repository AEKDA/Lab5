package logic.instruction;

import logic.Instruction;
import io.Cin;
import models.MovieCollection;
import models.Movie;

public class Insert_adInstruction implements Instruction {

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Error! ...");
        }
        Movie m = new Movie();
        m.getElement(Cin.peek());
        MovieCollection.getInstance().getData().insertElementAt(m, Integer.parseInt(args[1]));
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
