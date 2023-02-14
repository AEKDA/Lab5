package logic;

import java.util.Scanner;

import exception.IncorrectArgumentException;
import exception.IncorrectInstructionException;
import java.util.Stack;
import logic.instruction.*;

public class InstructionListener<T extends CollectionElement> {
    
    private Scanner in;
    private Stack<Instruction> instructionStack;
    private CollectionManager<T> collectionManager;
    private boolean isWork;


    public InstructionListener(CollectionManager<T> collectionManager) {
        isWork = true;
        in = new Scanner(System.in);
        instructionStack = new Stack<>();
        this.collectionManager = collectionManager;
    }

    public InstructionListener<T> addInstruction(Instruction instruction) {
        instructionStack.push(instruction);
        return this;
    }

    public void start() {
        setBaseInstruction();
        while(isWork) {
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
            catch(IncorrectArgumentException e) {
                System.out.println(e);
            }
        }
    }
    public void stop() {
        isWork = false;
    }

    private void setBaseInstruction() {
        addInstruction(new HelpInstruction(instructionStack));
        addInstruction(new ClearInstruction(collectionManager));
        addInstruction(new InfoInstruction(collectionManager));
        addInstruction(new ShowInstruction(collectionManager));
        addInstruction(new AddInstruction(System.in));
        addInstruction(new UpdateInstruction());
        addInstruction(new ExitInstruction(this));
        addInstruction(new ShuffleInstruction(collectionManager));
        addInstruction(new Average_of_oscars_countInstruction(collectionManager));
        addInstruction(new SaveInstruction(collectionManager));
        addInstruction(new Execution_scriptInstruction(collectionManager));
        addInstruction(new Remove_by_idInstruction(collectionManager));
        addInstruction(new Insert_adInstruction(collectionManager));
        addInstruction(new Add_if_maxInstruction(collectionManager));
        addInstruction(new Filter_contains_nameInstruction(this));
        addInstruction(new Print_descendingInstruction(collectionManager));
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
