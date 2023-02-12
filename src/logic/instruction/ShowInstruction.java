package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;

public class ShowInstruction implements Instruction{
    private CollectionManager<?> collectionManager;
    public ShowInstruction(CollectionManager<?> collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String about() {
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute(String[] args) {
        for(Object element: collectionManager.getData()) {
            element.toString();
        }
    }
}
