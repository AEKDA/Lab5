package logic;

import java.util.Scanner;

import exception.IncorrectArgument;
import exception.IncorrectInstructionException;
import java.util.Stack;
import logic.instruction.*;

public class InstructionListener {
    
    private Scanner in;
    private Stack<Instruction> instructionStack;
    private CollectionManager<?> collectionManager;


    public InstructionListener(CollectionManager<?> collectionManager) {
        in = new Scanner(System.in);
        instructionStack = new Stack<>();
        this.collectionManager = collectionManager;
    }

    public InstructionListener addInstruction(Instruction instruction) {
        instructionStack.push(instruction);
        return this;
    }

    public void start() {
        setBaseInstruction();
        while(true) {
            try {
                String[] args = inputInstructionArgs();
                Instruction current = getInstruction(args);
                current.execute(args);
            }
            catch (IncorrectInstructionException e) {
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException e) {
                System.out.println("Error! The argument must be a number");
            }
            catch(IncorrectArgument e) {
                System.out.println(e);
            }
        }
    }

    private void setBaseInstruction() {
        addInstruction(new HelpInstruction(instructionStack));
        addInstruction(new ClearInstruction(collectionManager));
        addInstruction(new InfoInstruction(collectionManager));
    }

    private String[] inputInstructionArgs() {
        System.out.printf("-> ");
        String text = in.nextLine().strip();
        String[] input = text.split(" +");
        return input;
    }

    private Instruction getInstruction(String[] text) throws IncorrectInstructionException {
        if(text.length == 0) {throw new IncorrectInstructionException("Error! You have not entered the instructions");}

        for(Instruction instruction : instructionStack) {
            if(instruction.getName().equals(text[0])) {
                return instruction;
            }
        }
        throw new IncorrectInstructionException("Error! The entered instruction is undefined");
    }
}
