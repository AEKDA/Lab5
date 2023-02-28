package logic.instruction;

import io.JSONMovieLoaer;
import logic.Args;
import logic.Instruction;
import models.MovieCollection;
import models.Movie;

public class SaveMovieInstruction implements Instruction {

    @Override
    public void execute(String[] args) {
        JSONMovieLoaer<Movie> loader = new JSONMovieLoaer<>();
        loader.write(Args.getPathToFile(), MovieCollection.getInstance().getData().toArray());
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String about() {
        return "сохранить коллекцию в файл";
    }
}
