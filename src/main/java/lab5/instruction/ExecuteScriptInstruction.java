package lab5.instruction;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

import lab5.io.BaseReader;
import lab5.io.Logger;
import lab5.logic.Instruction;
import lab5.logic.InstructionListener;


/**
 * Комманда исполняет скрипт, который был передан ей
 */
public class ExecuteScriptInstruction implements Instruction {
    private InstructionListener instructionListener;
    Stack<String> pathStack = new Stack<>();

    public ExecuteScriptInstruction(InstructionListener instructionListener) {
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
        } catch (IOException e) {
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
