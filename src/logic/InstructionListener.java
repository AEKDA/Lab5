package logic;

import java.util.Scanner;
import java.io.InputStream;

import exception.IncorrectInstructionException;
import java.util.Stack;
import models.Movie;
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

    // TODO: fix system.out
    public void start(InputStream is) {
        Scanner in = new Scanner(is);
        while (isWork) {
            try {
                String[] args = inputInstructionArgs(in);
                Instruction current = getInstruction(args);
                current.execute(args);
            } catch (IncorrectInstructionException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error! The argument must be a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
        in.close();
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
                .addInstruction(new SaveInstruction())
                .addInstruction(new Remove_by_idInstruction())
                .addInstruction(new Print_descendingInstruction())
                .addInstruction(new Execute_scriptInstruction(this))
                .addInstruction(new Filter_contains_nameInstruction())
                .addInstruction(new Insert_adInstruction())
                .addInstruction(new Add_if_maxInstruction());

    }

    // TODO: fix system.out
    private String[] inputInstructionArgs(Scanner in) {
        String[] input = new String[3];
        System.out.printf("-> ");
        String text = in.nextLine().strip();
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
        throw new IncorrectInstructionException("Error! The entered instruction is undefined");
    }
}
