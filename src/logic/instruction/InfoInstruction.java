package logic.instruction;

import logic.Instruction;
import logic.CollectionManager;

public class InfoInstruction implements Instruction{

    private CollectionManager<?> collectionManager;

    public InfoInstruction(CollectionManager<?> collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        System.out.println("--->Information about the collection:");
        System.out.println("--->Type: " + collectionManager.getData().getClass().toString());
        System.out.println("--->Date of creation: " + collectionManager.getInitDate().toString());
        System.out.println("--->Elements count: " + Integer.toString(collectionManager.getData().size()));
    }
    @Override
    public String getName() {
        return "info";
    }
    @Override
    public String about() {
        return "вывести в стандартный поток вывода информацию о коллекции";
    }

}

