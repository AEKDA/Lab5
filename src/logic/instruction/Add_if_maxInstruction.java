package logic.instruction;

import models.Movie;
import models.MovieCollection;

import io.Cin;

import logic.Instruction;

public class Add_if_maxInstruction implements Instruction {
    @Override
    public void execute(String[] args) {
        Movie m = new Movie();
        m.getElement(Cin.peek());
        for (Movie movie : MovieCollection.getInstance().getData()) {
            if (movie.getTotalBoxOffice() >= m.getTotalBoxOffice()) {
                return;
            }
        }
        MovieCollection.getInstance().pushElement(m);
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
