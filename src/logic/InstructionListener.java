package logic;

import java.util.Scanner;
import java.io.InputStream;

import exception.IncorrectArgumentException;
import exception.IncorrectInstructionException;
import java.util.Stack;
import data.Movie;
import logic.instruction.*;

public class InstructionListener {
    
    private Stack<Instruction> instructionStack;
    private CollectionManager<Movie> collectionManager;
    private boolean isWork;


    public InstructionListener(CollectionManager<Movie> collectionManager) {
        isWork = true;
        instructionStack = new Stack<>();
        this.collectionManager = collectionManager;
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
        Scanner in = new Scanner(is);
        while(isWork) {
            try {
                String[] args = inputInstructionArgs(in);
                Instruction current = getInstruction(args);
                current.execute(args);
            }
            catch (IncorrectInstructionException e) {
                System.out.println(e.getMessage());
            }
            catch(NumberFormatException e) {
                System.out.println("Error! The argument must be a number");
            }
            catch(IncorrectArgumentException e) {
                System.out.println(e);
            }
        }
        in.close();
    }
    public void stop() {
        isWork = false;
    }


    private void setBaseInstruction() {
        addInstruction(new HelpInstruction(getInstructionStack())).
        addInstruction(new ClearInstruction(collectionManager)).
        addInstruction(new InfoInstruction(collectionManager)).
        addInstruction(new ShowInstruction(collectionManager)).
        addInstruction(new AddInstruction(System.in)).
        addInstruction(new UpdateInstruction()).
        addInstruction(new ExitInstruction(this)).
        addInstruction(new ShuffleInstruction(collectionManager)).
        addInstruction(new Average_of_oscars_countInstruction(collectionManager)).
        addInstruction(new SaveInstruction(collectionManager)).
        addInstruction(new Remove_by_idInstruction(collectionManager)).
        addInstruction(new Print_descendingInstruction(collectionManager));
        addInstruction(new Execute_scriptInstruction(this));
        addInstruction(new Filter_contains_nameInstruction(collectionManager));
        addInstruction(new Insert_adInstruction(collectionManager)).
        addInstruction(new Add_if_maxInstruction(collectionManager));
    }

    private String[] inputInstructionArgs(Scanner in) {
        System.out.printf("-> ");
        String text = in.nextLine().strip();
        String[] input = text.split(" +");
        return input;
    }

    private Instruction getInstruction(String[] args) throws IncorrectInstructionException {
        if(args.length == 0) {throw new IncorrectInstructionException("Error! You have not entered the instructions");}

        for(Instruction instruction : instructionStack) {
            if(instruction.getName().equals(args[0])) {
                return instruction;
            }
        }
        throw new IncorrectInstructionException("Error! The entered instruction is undefined");
    }
}
