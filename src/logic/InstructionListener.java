package logic;

import java.io.InputStream;

import exception.IncorrectInstructionException;
import io.Cin;
import io.Logger;

import java.util.Stack;
import logic.instruction.*;

public class InstructionListener {

    private Stack<Instruction> instructionStack;
    private boolean isWork;

    public InstructionListener() {
        isWork = true;
        instructionStack = new Stack<>();
        setBaseInstruction();
    }

    public InstructionListener addInstruction(Instruction instruction) {
        instructionStack.push(instruction);
        return this;
    }

    public Stack<Instruction> getInstructionStack() {
        return instructionStack;
    }

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

    public void stop() {
        isWork = false;
    }

    private void setBaseInstruction() {
        addInstruction(new HelpInstruction(getInstructionStack()))
                .addInstruction(new ClearInstruction())
                .addInstruction(new InfoInstruction())
                .addInstruction(new ShowInstruction())
                .addInstruction(new AddInstruction())
                .addInstruction(new UpdateInstruction())
                .addInstruction(new ExitInstruction(this))
                .addInstruction(new ShuffleInstruction())
                .addInstruction(new Average_of_oscars_countInstruction())
                .addInstruction(new SaveMovieInstruction())
                .addInstruction(new Remove_by_idInstruction())
                .addInstruction(new Print_descendingInstruction())
                .addInstruction(new Execute_scriptInstruction(this))
                .addInstruction(new Filter_contains_nameInstruction())
                .addInstruction(new Insert_adInstruction())
                .addInstruction(new Add_if_maxInstruction());

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
