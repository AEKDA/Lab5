package logic.instruction;

import logic.Instruction;

public class UpdateInstruction implements Instruction {
    @Override
    public void execute(String[] args) {

    }
    @Override 
    public String getName() {
        return "update";
    }
    @Override
    public String about() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }
}
