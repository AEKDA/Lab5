package logic.instruction;

import io.JSONLoaer;
import logic.Args;
import logic.Instruction;
import models.MovieCollection;
import models.Movie;

public class SaveMovieInstruction implements Instruction {

    @Override
    public void execute(String[] args) {
        JSONLoaer<Movie> loader = new JSONLoaer<>();
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
