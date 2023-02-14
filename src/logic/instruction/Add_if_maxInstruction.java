package logic.instruction;

import logic.Instruction;

public class Add_if_maxInstruction implements Instruction {
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
