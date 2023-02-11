package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;

public class ClearInstruction extends Instruction{
    public ClearInstruction() {
        super("clear", false, false);
    }
    @Override
    public void execute(CollectionManager collectionManager) {
        collectionManager.clear();
    }
}