
import models.MovieCollection;
import logic.Args;
import logic.InstructionListener;

public class Main {
    //TODO - fix ALL Scanners
    public static void main(String[] args) {
        Args.setArgs(args);
        MovieCollection.getInstance().setStartData();
        InstructionListener instructionListener = new InstructionListener();

        instructionListener.start(System.in);
    }

}
