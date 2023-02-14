package logic;

import exception.IncorrectArgumentException;

public interface Instruction {

    public void execute(String[] args) throws IncorrectArgumentException;

    public String getName();

    public String about();
}