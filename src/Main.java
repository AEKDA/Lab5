
import models.MovieCollection;
import logic.Args;
import logic.InstructionListener;

public class Main {
    public static void main(String[] args) {
        Args.setArgs(args);
        MovieCollection.getInstance().setStartData();
        InstructionListener instructionListener = new InstructionListener();

        instructionListener.start(System.in);
        MovieCollection.getInstance().save();
    }

}
