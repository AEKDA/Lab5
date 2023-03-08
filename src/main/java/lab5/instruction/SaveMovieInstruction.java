package lab5.instruction;

import lab5.io.JSONMovieLoaer;
import lab5.logic.FileManager;
import lab5.logic.Instruction;
import lab5.models.MovieCollection;


/**
 * Команда сохраняет всю коллекцию в файл
 */
public class SaveMovieInstruction implements Instruction {

    @Override
    public void execute(String[] args) {
        JSONMovieLoaer loader = new JSONMovieLoaer();
        loader.write(FileManager.get().getPathToCollection(), MovieCollection.getInstance().getData().toArray());
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
