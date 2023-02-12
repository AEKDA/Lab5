package logic.instruction;

import logic.Instruction;

public class Remove_by_id implements Instruction {
    @Override
    public void execute(String[] args) {

    }
    @Override 
    public String getName() {
        return "remove_by_id";
    }
    @Override
    public String about() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}
