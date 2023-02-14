package logic.instruction;

import logic.Instruction;

public class Insert_adInstruction implements Instruction {
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
