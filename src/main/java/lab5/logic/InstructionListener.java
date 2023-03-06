package lab5.logic;

import java.io.InputStream;

import lab5.io.Cin;
import lab5.io.Logger;

import java.util.LinkedList;

/**
 * A class that receives instructions from a user or from a file and processes
 * them by calling the appropriate instructions
 */
public class InstructionListener implements Observable {

    private boolean isWork;
    private LinkedList<Observer> deque = new LinkedList<>();
    private String[] args;

    public InstructionListener() {
        isWork = true;
    }

    @Override
    public void notifyObservers() {
        for (Observer o : deque) {
            o.update(args);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        deque.addLast(o);
    }

    @Override
    public void removeObserver(Observer o) {
        deque.remove(o);
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
                if (is == System.in) {
                    args = inputInstructionArgs(Cin.peek());
                } else if (Cin.peek().getScanner().hasNextLine()) {
                    args = inputFromFileInstructionArgs(Cin.peek());
                } else {
                    break;
                }
                notifyObservers();
            } catch (NumberFormatException e) {
                Logger.get().writeLine("Error! The argument must be a number");
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
}
