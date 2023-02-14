package logic.instruction;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import loader.BaseReader;
import logic.Instruction;
import logic.InstructionListener;

public class Execution_scriptInstruction implements Instruction {
    private InstructionListener instructionListener;
    
    public Execution_scriptInstruction(InstructionListener instructionListener) {
        this.instructionListener = instructionListener;
    }
    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if(args.length != 2) 
            throw new IllegalArgumentException("Error! The arguments are not correct");
        try {
        String script;
        BaseReader br = new BaseReader(args[2]);
        script = br.read();
        instructionListener.start(new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)));
        } catch(FileNotFoundException e) {
            System.out.println("Error! File not Found");
        }
    }
    @Override 
    public String getName() {
        return "execute_script";
    }
    @Override
    public String about() {
        return "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
