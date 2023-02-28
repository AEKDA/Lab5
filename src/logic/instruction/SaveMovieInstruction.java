package logic.instruction;

import io.JSONMovieLoaer;
import logic.Args;
import logic.Instruction;
import models.MovieCollection;


/**
 * Команда сохраняет всю коллекцию в файл
 */
public class SaveMovieInstruction implements Instruction {

    @Override
    public void execute(String[] args) {
        JSONMovieLoaer loader = new JSONMovieLoaer();
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
