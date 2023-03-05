package logic.instruction;

import models.MovieCollection;
import logic.Instruction;

import java.util.function.Predicate;

import models.Movie;

/**
 * Команда удаляет элемент из коллекции, id которого равен заданному
 */
public class RemoveByIdInstruction implements Instruction {

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Error! input args incorrect!");
        }
        MovieCollection.getInstance().getData().removeIf(new Predicate<Movie>() {
            public boolean test(Movie m) {
                return m.getId() == Integer.parseInt(args[1]);
            }
        });
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String about() {
        return "удалить элемент из коллекции по его id";
    }
}
