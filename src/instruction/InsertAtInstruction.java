package instruction;

import logic.Instruction;
import io.Cin;
import io.Logger;
import models.MovieCollection;
import models.Movie;

/**
 * Команда добавляет элемент в заданную позицию в коллекции
 */
public class InsertAtInstruction implements Instruction {

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Error! ...");
        }
        Movie m = new Movie();
        m.getElement(Cin.peek());
        try {
        MovieCollection.getInstance().getData().insertElementAt(m, Integer.parseInt(args[1]));
        } catch (ArrayIndexOutOfBoundsException e) {
            Logger.get().writeLine("Error! this index doesn't exist");
        }
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
