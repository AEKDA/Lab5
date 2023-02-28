package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Класс, для чтения и записи файлов, реализованный с помощью
 * {@link java.io.BufferedInputStream}
 */
public class BaseReader {
    private BufferedInputStream bufferedInputStream;
    private int length;

    /**
     * 
     * @param path путь до файлв
     * @throws FileNotFoundException
     */
    public BaseReader(String path) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        try {
            length = fileInputStream.available();
            if (length == 0) {
                throw new IOException("Файл пуст");
            }
        } catch (IOException e) {
            Logger.get().writeLine(e.getMessage());
        }
        bufferedInputStream = new BufferedInputStream(fileInputStream);
    }

    /**
     * Читает весь файл
     * 
     * @return Строку, в которо содержится весь файл
     */
    public String read() {
        StringBuilder sb = new StringBuilder();
        byte[] byteData = new byte[length];

        try {
            bufferedInputStream.read(byteData, 0, length);
            sb.append(new String(byteData, "UTF-8"));
        } catch (IOException e) {
            Logger.get().writeLine(e.getMessage());
        }

        return sb.toString();

    }
}
