package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;

public class HelpInstruction implements Instruction{
    private String name;
    private CollectionManager collectionManager;

    public HelpInstruction(CollectionManager collectionManager) {
        name = "help";
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute(String[] args) {
        System.out.println("It's help");

    }
    @Override
    public String getName() {
        return name;
    }
}