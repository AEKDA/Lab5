package logic.instruction;

import java.io.InputStream;
import java.util.Scanner;

import exception.IncorrectArgumentException;
import logic.Instruction;

public class AddInstruction implements Instruction {
    Scanner scan;
    public AddInstruction(InputStream source) {
        this.scan = new Scanner(source);
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
        return "add {element} : добавить новый элемент в коллекцию";
    }
}
