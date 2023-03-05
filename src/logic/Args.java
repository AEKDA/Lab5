package logic;

import java.io.File;
import java.util.Scanner;

import io.Logger;

/**
 * Класс содерит аргумент командной строки, которые можно получить из любой
 * точки программы
 */

public class Args {
    private String args[];
    private String path;
    private static Args instance = null;

    private Args() {
        path = new String();
        args = new String[1];
    }

    public static Args get() {
        if(instance == null) {
            instance = new Args();
        }
        return instance;
    }

    /**
     * @param args
     */
    public void setArgs(String[] args) {
        this.args = args;
        check();
    }

    /**
     * Статический метод Который
     * 
     * @return Возвращает аргументы командной строки
     */
    public String[] getArgs() {
        return args;
    }

    @SuppressWarnings("all")
    private void check() {

        if (getArgs().length != 1) {
            Logger.get().writeLine("Error! You didn't specify the path to the file");
            Logger.get().writeLine("Entered File path: ");
            Scanner in = new Scanner(System.in);
            args = new String[1];
            args[0] = in.nextLine();

        }
        path = getArgs()[0];

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
    public String getPathToFile() {
        return path;
    }
}
