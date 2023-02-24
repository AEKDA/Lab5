package logic.instruction;

import models.MovieCollection;
import logic.Instruction;
import io.Logger;

public class ShowInstruction implements Instruction{
    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String about() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public void execute(String[] args) {
        for(Object element: MovieCollection.getInstance().getData()) {
            Logger.get().writeLine(element.toString());
        }
    }
}
