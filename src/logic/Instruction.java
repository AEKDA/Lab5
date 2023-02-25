package logic;

public interface Instruction {

    public void execute(String[] args) throws IllegalArgumentException;

    public String getName();

    public String about();
}