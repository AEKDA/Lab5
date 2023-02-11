package logic;

import java.util.Scanner;
import exception.IncorrectInstructionException;

import java.util.Stack;

class HelpInstruction extends Instruction{
    public HelpInstruction() {
        super("help", false, false);
    }
    @Override
    public void execute() {
        System.out.println("It's help");
    }
}

public class InstructionListener {
    
    private Scanner in;
    private Stack<Instruction> instructionStack;


    public InstructionListener() {
        in = new Scanner(System.in);
        instructionStack = new Stack<>();
    }

    public Stack<Instruction> addInstruction(Instruction instruction) {
        instructionStack.push(instruction);
        return this.instructionStack;
    }

    public void start() {
        addInstruction(new HelpInstruction());
        while(true) {
            try {
                Instruction current = getInstruction();
                current.execute();
            }
            catch (IncorrectInstructionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Instruction getInstruction() throws IncorrectInstructionException {
        String tmp = in.nextLine();
        String[] input = tmp.split(" +");
        int arg;
        for(Instruction instruction : instructionStack) {
            if(instruction.getName().equals(input[0])) {
                if(instruction.hasArg() && input.length == 2) {
                    if(instruction.hasElement()) {
                        getElement();
                    }
                    if(instruction.hasArg() ) {
                        try {
                        arg = Integer.parseInt(input[1]);
                        }
                        catch(NumberFormatException e) {
                            System.out.println("Error! The argument must be a number");
                        }
                    }
                    return instruction;
                }
                else if (!instruction.hasArg() && input.length == 1) {
                    if(instruction.hasElement()){
                        getElement();
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

    private void getElement() {

    }
}
