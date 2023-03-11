package lab5.instruction;

import lab5.models.MovieCollection;
import lab5.logic.Instruction;
import lab5.io.Cin;
import lab5.models.Movie;

/**
 * Команда заменяет элемент id которого равен заданному
 */
public class UpdateInstruction implements Instruction {

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Error! the instruction is incorrect");
        }
        Movie m = new Movie();
        m.getElement(Cin.peek());

        for (int i = 0; i < MovieCollection.getInstance().getData().size(); i++) {
            if (MovieCollection.getInstance().getData().get(i).getId() == Integer.parseInt(args[1])) {
                m.setId(Integer.parseInt(args[1]));
                MovieCollection.getInstance().getData().set(i, m);
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
