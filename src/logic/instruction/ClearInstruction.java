package logic.instruction;

import logic.Instruction;
import models.MovieCollection;

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