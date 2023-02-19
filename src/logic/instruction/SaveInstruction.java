package logic.instruction;

import logic.Instruction;
import logic.CollectionManager;

public class SaveInstruction implements Instruction {

    @Override
    public void execute(String[] args) {

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
