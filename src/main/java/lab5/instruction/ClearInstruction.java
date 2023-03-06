package lab5.instruction;

import lab5.logic.Instruction;
import lab5.models.MovieCollection;

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