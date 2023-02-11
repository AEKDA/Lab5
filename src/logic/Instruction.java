package logic;

public abstract class Instruction {
    private String name;
    private boolean arg;
    private boolean element;

    public Instruction(String name, boolean hasArg, boolean hasElement) {
        this.name = name;
        this.arg = hasArg;
        element = hasElement;
    }

    public abstract void execute();

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
}