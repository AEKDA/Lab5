package logic.instruction;

import logic.Instruction;

public class Print_descendingInstruction implements Instruction {
    @Override
    public void execute(String[] args) {

    }
    @Override 
    public String getName() {
        return "print_descending";
    }
    @Override
    public String about() {
        return "print_descending : вывести элементы коллекции в порядке убывания";
    }
}
