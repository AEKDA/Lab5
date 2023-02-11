package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;
import data.Movie;

public class HelpInstruction extends Instruction{
    int argument;
    Movie movie;
    public HelpInstruction() {
        super("help", false, false);
    }
    @Override
    public void execute(CollectionManager collectionManager) {
        System.out.println("It's help");
    }
    @Override
    public void setArg(int arg) {
        argument = arg;
    }
    @Override
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}