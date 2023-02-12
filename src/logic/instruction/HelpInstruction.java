package logic.instruction;

import java.util.Stack;
import logic.Instruction;

public class HelpInstruction implements Instruction{
    private String name;
    private Stack<Instruction> instructionStack;

    public HelpInstruction(Stack<Instruction> instructionStack) {
        name = "help";
        this.instructionStack = instructionStack;
    }
    @Override
    public void execute(String[] args) {
        for(Instruction inst: instructionStack) {
            System.out.println("--->  " + inst.about());
        }

    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String about() {
        return "help : вывести справку по доступным командам";
    }

}