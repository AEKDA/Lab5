package logic.instruction;

import logic.Instruction;
import logic.CollectionManager;

public class InfoInstruction implements Instruction{

    private String name;
    private CollectionManager<?> collectionManager;

    public InfoInstruction(CollectionManager<?> collectionManager) {
        this.name = "info";
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        for(Object element: collectionManager.getData()) {
            element.toString();
        }
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String about() {
        return "info : вывести в стандартный поток вывода информацию о коллекции";
    }

}

