package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;

public class ClearInstruction implements Instruction{
    private CollectionManager<?> collectionManager;

    public ClearInstruction(CollectionManager<?> collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clear();
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