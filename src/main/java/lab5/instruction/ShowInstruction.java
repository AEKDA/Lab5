package lab5.instruction;

import lab5.models.MovieCollection;
import lab5.logic.Instruction;
import lab5.io.Logger;


/**
 * Команда выводит все элементы коллекции в строковом представлении
 */
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
