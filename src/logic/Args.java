package logic;

import java.io.File;
import java.util.Scanner;

import io.Logger;

/**
 * Класс содерит аргумент командной строки, которые можно получить из любой
 * точки программы
 */

public class Args {
    private static String args[];
    private static String path;

    /**
     * @param args
     */
    public static void setArgs(String[] args) {
        Args.args = args;
        check();
    }

    /**
     * Статический метод Который
     * @return Возвращает аргументы командной строки
     */
    public static String[] getArgs() {
        return args;
    }

    @SuppressWarnings("all")
    private static void check() {

        if (getArgs().length != 1) {
            Logger.get().writeLine("Error! You didn't specify the path to the file");
            Logger.get().writeLine("Entered File path: ");
            Scanner in = new Scanner(System.in);
            args = new String[1];
            args[0] = in.nextLine();

        }
        path = Args.getArgs()[0];

        File f = new File(path);
        while (!f.isFile()) {
            Logger.get().writeLine("Error! You didn't specify the path to the file");
            Logger.get().writeLine("Entered File path: ");
            Scanner in = new Scanner(System.in);
            path = in.nextLine();
            f = new File(path);
        }

    }

    /**
     * 
     * @return Возвращает путь до файла, в котором хранятся данные о элементах
     *         коллекции
     */
    public static String getPathToFile() {
        return path;
    }
}
