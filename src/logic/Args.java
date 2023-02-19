package logic;

import java.io.File;
import java.util.Scanner;

public class Args {
    private static String args[];
    private static String path;

    public static void setArgs(String[] args) {
        Args.args = args;
        check();
    }

    public static String[] getArgs() {
        return args;
    }

    // TODO: fix system.out
    private static void check() {

        if (getArgs().length != 1) {
            System.err.println("Error! You didn't specify the path to the file");
            System.out.println("Entered File path: ");
            Scanner in = new Scanner(System.in);
            path = in.nextLine();

        } else {
            path = Args.getArgs()[0];
        }

        File f = new File(path);
        while (!f.isFile()) {
            System.err.println("Error! You didn't specify the path to the file");
            System.out.println("Entered File path: ");
            Scanner in = new Scanner(System.in);
            path = in.nextLine();
            f = new File(path);
        }
        
    }

    public static String getPathToFile() {
        return path;
    }
}
