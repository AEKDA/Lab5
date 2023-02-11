package logic;

import java.util.Scanner;
import exception.IncorrectInstructionException;
import java.util.Stack;
import data.Movie;
import logic.instruction.*;

public class InstructionListener {
    
    private Scanner in;
    private Stack<Instruction> instructionStack;
    private CollectionManager collectionManager;


    public InstructionListener(CollectionManager collectionManager) {
        in = new Scanner(System.in);
        instructionStack = new Stack<>();
        this.collectionManager = collectionManager;
    }

    public InstructionListener addInstruction(Instruction instruction) {
        instructionStack.push(instruction);
        return this;
    }

    public void start() {
        addInstruction(new HelpInstruction());
        addInstruction(new ClearInstruction());
        while(true) {
            try {
                Instruction current = getInstruction();
                current.execute(collectionManager);
            }
            catch (IncorrectInstructionException e) {
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException e) {
                System.out.println("Error! The argument must be a number");
            }
        }
    }

    private Instruction getInstruction() throws IncorrectInstructionException, NumberFormatException {
        String tmp = in.nextLine();
        if(tmp.isEmpty()) {throw new IncorrectInstructionException("Error! You have not entered the instructions");}
        String[] input = tmp.split(" +");
        int arg;
        for(Instruction instruction : instructionStack) {
            if(instruction.getName().equals(input[0])) {
                if(instruction.hasArg() && input.length == 2) {
                    if(instruction.hasElement()) {
                        Movie movie = getElement();
                        instruction.setMovie(movie);
                    }
                    if(instruction.hasArg() ) {
                        arg = Integer.parseInt(input[1]);
                        instruction.setArg(arg);
                    }
                    return instruction;
                }
                else if (!instruction.hasArg() && input.length == 1) {
                    if(instruction.hasElement()){
                        Movie movie = getElement();
                        instruction.setMovie(movie);
                    }
                    return instruction;
                }
                else {
                    throw new IncorrectInstructionException("Error! The entered instruction incorrect");
                }
            }
        }
        throw new IncorrectInstructionException("Error! The entered instruction is undefined");
    }

    private Movie getElement() {
        return null;
    }
}
