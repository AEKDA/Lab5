package loader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseReader {
    private BufferedInputStream bufferedInputStream;

    public BaseReader(String path) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        bufferedInputStream = new BufferedInputStream(fileInputStream);
    }

    public String read() {
        StringBuilder sb = new StringBuilder();
        byte[] byteData = new byte[2048];
        
        try {
            int res = 0;
            do {
                res = bufferedInputStream.read(byteData, 0, 2048);
                sb.append(new String(byteData, "UTF-8"));
            } while(res == 2048);
            if(res != -1) {
                byte[] lastData = new byte[res];
                res = bufferedInputStream.read(lastData, 0, res);
                sb.append(new String(lastData, "UTF-8"));
            }
        } catch (IOException e) {
            System.out.println("Error! No access to the file");
        }

        return sb.toString();

    }
}
