package logic;

import data.Movie;

public abstract class Instruction {
    private String name;
    private boolean arg;
    private boolean element;

    public Instruction(String name, boolean hasArg, boolean hasElement) {
        this.name = name;
        this.arg = hasArg;
        element = hasElement;
    }

    public abstract void execute(CollectionManager collectionManager);

    public Instruction(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasArg() {
        return this.arg;
    }

    public boolean hasElement() {
        return element;
    }
    public void setMovie(Movie movie) {}
    public void setArg(int movie) {}
}