package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;

public class Add_if_maxInstruction implements Instruction {
    private CollectionManager<?> collectionManager;

    public Add_if_maxInstruction(CollectionManager<?> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {

    }
    @Override 
    public String getName() {
        return "add_if_max";
    }
    @Override
    public String about() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }
}
