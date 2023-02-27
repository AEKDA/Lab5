package logic.instruction;

import models.MovieCollection;
import logic.Instruction;
import io.Cin;
import models.Movie;

public class UpdateInstruction implements Instruction {

    @Override
    public void execute(String[] args) {
        Movie m = new Movie();
        m.getElement(Cin.peek());

        for (Movie movie : MovieCollection.getInstance().getData()) {
            if (movie.getId() == m.getId()) {
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
