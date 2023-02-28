package logic.instruction;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

import io.BaseReader;
import io.Logger;
import logic.Instruction;
import logic.InstructionListener;


/**
 * Комманда исполняет скрипт, который был передан ей
 */
public class Execute_scriptInstruction implements Instruction {
    private InstructionListener instructionListener;
    Stack<String> pathStack = new Stack<>();

    public Execute_scriptInstruction(InstructionListener instructionListener) {
        this.instructionListener = instructionListener;
    }

    @Override
    public void execute(String[] args) throws IllegalArgumentException {
        if (args.length != 2)
            throw new IllegalArgumentException("Error! The arguments are not correct");
        try {
            if (!pathCheck(args[1])) {
                return;
            }
            pathStack.push(args[1]);
            String script;
            BaseReader br = new BaseReader(args[1]);
            script = br.read();
            instructionListener.start(new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)));
        } catch (FileNotFoundException | IllegalArgumentException e) {
            Logger.get().writeLine("Error! File not Found");
        }
        pathStack.pop();
    }

    public boolean pathCheck(String path) {
        for (String string : this.pathStack) {
            if (string.equals(path)) {
                return false;
            }
        }
        return true;
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
