package lab5.logic;

import java.io.File;
import java.io.IOException;

import lab5.io.Logger;
import lab5.io.Cin;

/**
 * Класс содерит аргумент командной строки, которые можно получить из любой
 * точки программы
 */

public class FileManager {
    private static FileManager instance = null;
    private String path;
    private String pathInfo = "data/CollectionInfo.json";

    private FileManager() {
    }

    public static FileManager get() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    /**
     * @param args
     */
    public void setStandartPathFromArgs(String[] args) {
        if (args.length != 1) {
            path = checkInputPath("You didn't specify the path to the file");
        } else {
            path = args[0];
        }
        try {
            while (true) {
                File f = new File(path);
                if (f.isFile() && f.canRead() && f.canWrite()) {
                    break;
                } else if (f.isDirectory()) {
                    path = checkInputPath("You have entered a directory");
                    continue;
                } else {
                    try {
                        f.getParentFile().mkdirs();
                    } catch (NullPointerException e) {

                    }
                    if (f.createNewFile() && f.canRead() && f.canWrite()) {
                        break;
                    } else {
                        path = checkInputPath("The file cannot be created or used");
                        continue;
                    }
                }
            }
        } catch (IOException e) {
            Logger.get().writeLine(e.getMessage());
        }
    }

    private String checkInputPath(String errorMessage) {
        Logger.get().writeLine(errorMessage);
        Logger.get().write("Enter the path to the Collection\n-> ");
        Cin in = new Cin(System.in);
        return in.getScanner().nextLine();
    }

    /**
     * 
     * @return Возвращает путь до файла, в котором хранятся данные о элементах
     *         коллекции
     */
    public String getPathToCollection() {
        return path;
    }

    /**
     * 
     * @return Возвращает путь до файла, в котором хранится информация о коллекции
     */
    public String getPathToInfo() {
        return pathInfo;
    }
}
