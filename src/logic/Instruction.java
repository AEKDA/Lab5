package logic;

import exception.IncorrectArgument;

public interface Instruction {

    public void execute(String[] args) throws IncorrectArgument;

    public String getName();

    public String about();
}