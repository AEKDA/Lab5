package instruction;

import logic.Instruction;
import io.Cin;
import models.MovieCollection;
import models.Movie;
/**
 * Команда добавляет новый элемент в коллекцию
 */
public class AddInstruction implements Instruction {

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (args.length != 1)
            throw new IllegalArgumentException("Error! input args incorrect!");
        Movie m = new Movie();
        m.getElement(Cin.peek());

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
