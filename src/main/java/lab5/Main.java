package lab5;

import lab5.models.MovieCollection;
import lab5.logic.FileManager;
import lab5.logic.InstructionFetch;
import lab5.logic.InstructionListener;
import lab5.instruction.*;

public class Main {
    public static void main(String[] args) {
        FileManager.get().setStandartPathFromArgs(args);
        MovieCollection.getInstance().setStartData();
        InstructionListener instructionListener = new InstructionListener();

        InstructionFetch instructionFetch = new InstructionFetch();
        instructionFetch.addInstruction(new HelpInstruction(instructionFetch.getInstructionStack()))
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

        instructionListener.registerObserver(instructionFetch);
        instructionListener.start(System.in);

    }
}
