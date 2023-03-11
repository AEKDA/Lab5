package lab5.instruction;

import lab5.logic.Instruction;
import lab5.io.Cin;
import lab5.io.Logger;
import lab5.models.MovieCollection;
import lab5.models.Movie;

/**
 * Команда добавляет элемент в заданную позицию в коллекции
 */
public class InsertAtInstruction implements Instruction {

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Error! You didn't enter the index");
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
