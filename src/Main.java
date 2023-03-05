
import models.MovieCollection;
import logic.Args;
import logic.InstructionListener;
import logic.instruction.*;

public class Main {
    public static void main(String[] args) {
        Args.setArgs(args);
        MovieCollection.getInstance().setStartData();
        InstructionListener instructionListener = new InstructionListener();
        instructionListener.addInstruction(new HelpInstruction(instructionListener.getInstructionStack()))
                .addInstruction(new ClearInstruction())
                .addInstruction(new InfoInstruction())
                .addInstruction(new ShowInstruction())
                .addInstruction(new AddInstruction())
                .addInstruction(new UpdateInstruction())
                .addInstruction(new ExitInstruction(instructionListener))
                .addInstruction(new ShuffleInstruction())
                .addInstruction(new AverageOfOscarsCountInstruction())
                .addInstruction(new SaveMovieInstruction())
                .addInstruction(new RemoveByIdInstruction())
                .addInstruction(new PrintDescendingInstruction())
                .addInstruction(new ExecuteScriptInstruction(instructionListener))
                .addInstruction(new FilterContainsNameInstruction())
                .addInstruction(new InsertAtInstruction())
                .addInstruction(new AddIfMaxInstruction());

        instructionListener.start(System.in);
        MovieCollection.getInstance().save();
    }

}
