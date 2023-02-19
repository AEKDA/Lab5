package logic.instruction;

import java.util.Collections;
import java.util.Comparator;

import models.MovieCollection;
import models.Movie;
import logic.Instruction;

public class Print_descendingInstruction implements Instruction {

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Error! Argument of Instruction incorrect");
        }
        Collections.sort(MovieCollection.getInstance().getData(), new Comparator<Movie>() {
            public int compare(Movie t1, Movie t2) {
                return t1.getName().compareTo(t2.getName()) * -1;
            }
        });
        for (Object o : MovieCollection.getInstance().getData()) {
            System.out.println(o.toString());
        }
    }

    @Override
    public String getName() {
        return "print_descending";
    }

    @Override
    public String about() {
        return "вывести элементы коллекции в порядке убывания";
    }
}
