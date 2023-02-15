package logic.instruction;

import logic.Instruction;
import logic.CollectionManager;

public class Insert_adInstruction implements Instruction {
    private CollectionManager<?> collectionManager;
    public Insert_adInstruction(CollectionManager<?> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {

    }
    @Override 
    public String getName() {
        return "insert_at";
    }
    @Override
    public String about() {
        return "добавить новый элемент в заданную позицию";
    }
}
