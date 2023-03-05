package instruction;

import logic.Instruction;
import models.MovieCollection;
import io.Logger;

/**
 * Команда, которая выводит ифнормацию о коллекции
 */
public class InfoInstruction implements Instruction {

    public InfoInstruction() {
    }

    @Override
    public void execute(String[] args) {
        Logger.get().writeLine("--->Information about the collection:");
        Logger.get().writeLine("--->Type: " + MovieCollection.getInstance().getData().getClass().toString());
        Logger.get().writeLine("--->Date of creation: " + MovieCollection.getInstance().getInfo().getDate().toString());
        Logger.get().writeLine("--->Elements count: " + Integer.toString(MovieCollection.getInstance().getData().size()));
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String about() {
        return "вывести в стандартный поток вывода информацию о коллекции";
    }

}
