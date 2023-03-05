package logic;

import java.io.InputStream;

import exception.IncorrectInstructionException;
import io.Cin;
import io.Logger;

import java.util.Stack;

/**
 * A class that receives instructions from a user or from a file and processes
 * them by calling the appropriate instructions
 */
public class InstructionListener {

    private Stack<Instruction> instructionStack;
    private boolean isWork;

    public InstructionListener() {
        isWork = true;
        instructionStack = new Stack<>();
    }

    /**
     * Adds the passed instruction to the instruction stack
     * 
     * @param instruction The instruction that will be added to the stack
     * @return An instance of the same class, in order to be able to call functions
     *         along the chain
     */
    public InstructionListener addInstruction(Instruction instruction) {
        instructionStack.push(instruction);
        return this;
    }

    /**
     * @return {@link java.util.Stack} containing all instructions
     */
    public Stack<Instruction> getInstructionStack() {
        return instructionStack;
    }

    /**
     * Starts the instruction listener
     * 
     * @param is the input stream from which the instructions are taken
     */
    public void start(InputStream is) {
        Cin.push(new Cin(is));
        while (isWork) {
            try {
                String[] args;
                if (is == System.in) {
                    args = inputInstructionArgs(Cin.peek());
                } else if (Cin.peek().getScanner().hasNextLine()) {
                    args = inputFromFileInstructionArgs(Cin.peek());
                } else {
                    break;
                }
                Instruction current = getInstruction(args);
                current.execute(args);
            } catch (IncorrectInstructionException e) {
                Logger.get().writeLine(e.getMessage());
            } catch (NumberFormatException e) {
                Logger.get().writeLine("Error! The argument must be a number");
            } catch (IllegalArgumentException e) {
                Logger.get().writeLine(e.getMessage());
            }
        }
        if (Cin.peek().getType() != Cin.Type.STD) {
            Cin.peek().getScanner().close();
        }
        Cin.pop();
    }

    /**
     * stops execution of all listeners
     */
    public void stop() {
        isWork = false;
    }

    private String[] inputInstructionArgs(Cin in) {
        String[] input;
        Logger.get().write("-> ");
        String text = in.getScanner().nextLine().strip();
        input = text.split(" +");
        return input;
    }

    private String[] inputFromFileInstructionArgs(Cin in) {
        String[] input;
        String text = in.getScanner().nextLine().strip();
        input = text.split(" +");
        return input;
    }

    private Instruction getInstruction(String[] args) throws IncorrectInstructionException {
        if (args.length == 0) {
            throw new IncorrectInstructionException("Error! You have not entered the instructions");
        }

        for (Instruction instruction : instructionStack) {
            if (instruction.getName().equals(args[0])) {
                return instruction;
            }
        }
        throw new IncorrectInstructionException("Error! The entered instruction is undefined: " + args[0]);
    }
}
