package instruction;

import logic.Instruction;
import models.MovieCollection;

/**
 * Комманда очищает коллекцию
 */
public class ClearInstruction implements Instruction {

    public ClearInstruction() {
    }

    @Override
    public void execute(String[] args) {
        MovieCollection.getInstance().clear();
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String about() {
        return "очистить коллекцию";
    }
}