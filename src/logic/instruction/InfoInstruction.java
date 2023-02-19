package logic.instruction;

import logic.Instruction;
import models.MovieCollection;

public class InfoInstruction implements Instruction {

    public InfoInstruction() {
    }

    @Override
    public void execute(String[] args) {
        System.out.println("--->Information about the collection:");
        System.out.println("--->Type: " + MovieCollection.getInstance().getData().getClass().toString());
        System.out.println("--->Date of creation: " + MovieCollection.getInstance().getInitDate().toString());
        System.out.println("--->Elements count: " + Integer.toString(MovieCollection.getInstance().getData().size()));
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
