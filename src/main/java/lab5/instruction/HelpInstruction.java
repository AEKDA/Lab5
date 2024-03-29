package lab5.instruction;

import java.util.Stack;
import lab5.logic.Instruction;
import lab5.io.Logger;

/**
 * Команда, которая выводит информацию о всех остальных командах
 */
public class HelpInstruction implements Instruction {
    private String name;
    private Stack<Instruction> instructionStack;

    public HelpInstruction(Stack<Instruction> instructionStack) {
        name = "help";
        this.instructionStack = instructionStack;
    }

    @Override
    public void execute(String[] args) {
        for (Instruction inst : instructionStack) {
            Logger.get().writeLine("--->  " + inst.getName() + ": " + inst.about());
        }

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String about() {
        return "вывести справку по доступным командам";
    }

}