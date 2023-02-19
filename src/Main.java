import models.MovieCollection;

import java.time.ZonedDateTime;

import io.Logger;
import logic.Args;
import logic.InstructionListener;

public class Main {

    public static void main(String[] args) {
        // TODO: fix system.out
        Args.setArgs(args);
        Logger logger = new Logger(System.in, System.out);

        System.out.println(ZonedDateTime.now());

        MovieCollection.getInstance().setStartData();
        InstructionListener instructionListener = new InstructionListener();

        instructionListener.start(System.in);
    }

}