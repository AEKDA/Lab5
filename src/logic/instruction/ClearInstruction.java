package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;

public class ClearInstruction implements Instruction{
    private String name;
    private CollectionManager<?> collectionManager;

    public ClearInstruction(CollectionManager<?> collectionManager) {
        this.name = "clear";
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        collectionManager.clear();
    }

    @Override
    public String getName() {
        return name;
    }
}