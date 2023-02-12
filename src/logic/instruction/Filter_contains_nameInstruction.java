package logic.instruction;

import logic.Instruction;

public class Filter_contains_nameInstruction implements Instruction {
    @Override
    public void execute(String[] args) {

    }
    @Override 
    public String getName() {
        return "filter_contains_name";
    }
    @Override
    public String about() {
        return "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку";
    }
}
