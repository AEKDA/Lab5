package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseReader {
    private BufferedInputStream bufferedInputStream;
    private int length;

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

    public String read() {
        StringBuilder sb = new StringBuilder();
        byte[] byteData = new byte[length];

        try {
            bufferedInputStream.read(byteData, 0, length);
            sb.append(new String(byteData, "UTF-8"));
        } catch (IOException e) {
            Logger.get().writeLine(e.getMessage());
        }

        // try {
        // int res = 0;
        // do {
        // res = bufferedInputStream.read(byteData, 0, length);
        // sb.append(new String(byteData, "UTF-8"));
        // } while (sb.length() == 2 * length);
        // if (res != -1) {
        // byte[] lastData = new byte[res];
        // res = bufferedInputStream.read(lastData, 0, res);
        // sb.append(new String(lastData, "UTF-8"));
        // }
        // } catch (IOException e) {
        // Logger.get().writeLine("Error! No access to the file");
        // }

        return sb.toString();

    }
}
