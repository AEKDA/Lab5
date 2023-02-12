package logic.instruction;

import logic.Instruction;

public class AddInstruction implements Instruction {
    
    @Override
    public void execute(String[] args) {

    }
    @Override 
    public String getName() {
        return "add";
    }
    @Override
    public String about() {
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
