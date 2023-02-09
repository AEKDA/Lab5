package logic;

import java.util.Scanner;
import exception.IncorrectInstructionException;

public class InstructionListener {
    
    private CollectionManager collectionManager;
    private Scanner in;

    private class Instruction {
        private String name;
        private int arg;
        private Type type;
        

        public Instruction(String name, int arg) {
            this.name = name;
            this.arg = arg;
            this.type = Type.WithArg;
        }

        public Instruction(String name) {
            this.name = name;
            this.type = Type.WithoutArg;
        }
        public String getName() {
            return this.name;
        }
        public int getArg() {
            return this.arg;
        }
        public Type getType() {
            return this.type;
        }

        public enum Type {
            WithArg,
            WithoutArg
        }
    }

    private enum InstructionWithArgList {
        add,
        update,
        remove_by_id,
        execute_script,
        insert_at,
        add_if_max,
        filter_contains_name
    }
    private enum InstructionWithoutArgList {
        help,
        info,
        show,
        clear,
        save,
        exit,
        shuffle,
        average_of_oscars_count,
        print_descending
    }


    public InstructionListener() {
        in = new Scanner(System.in);
    }


    public InstructionListener(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void start() {
        try {
            getCommand();
        }
        catch (IncorrectInstructionException e) {
           System.out.println(e.getMessage());
        }
    }

    private Instruction getCommand() throws IncorrectInstructionException {
        String tmp = in.next();
        for (InstructionWithArgList c : InstructionWithArgList.values()) {
            if (c.name().equals(tmp)) {
                if (!in.hasNextInt()) {
                    throw new IncorrectInstructionException("Error! The argument must be required and must be a number");
                }
                int arg = in.nextInt();
                return new Instruction(tmp, arg);
            }
        }
        for (InstructionWithoutArgList c : InstructionWithoutArgList.values()) {
            if (c.name().equals(tmp)) {
                if (in.hasNextInt()) {
                    throw new IncorrectInstructionException("Error! ");
                }
                return new Instruction(tmp);
            }
        }
        throw new IncorrectInstructionException("Error! The entered instruction is undefined");
    }
}
