package logic.instruction;

import java.io.InputStream;

import exception.IncorrectArgumentException;
import logic.Instruction;

public class AddInstruction implements Instruction {
    InputStream scan;
    public AddInstruction(InputStream source) {
        this.scan = source;
    }
    @Override
    public void execute(String[] args) throws IncorrectArgumentException {
        if(args.length != 1)
            throw new IncorrectArgumentException("Error! input args incorrect!");

    }
    @Override 
    public String getName() {
        return "add";
    }
    @Override
    public String about() {
        return "добавить новый элемент в коллекцию";
    }
}
