package io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Logger {
    private InputStream is;
    private Scanner system_scan = new Scanner(System.in);
    private OutputStream os;

    public Logger(InputStream is, OutputStream os) {
        this.is = is;
        this.os = os;
    }

    public void SwitchInputStream(InputStream is) {
        this.is = is;
    }

    public void SwitchOutputStream(OutputStream os) {
        this.os = os;
    }

    public InputStream getInputStream() {
        return is;
    }

    public OutputStream getOutputStream() {
        return os;
    }

    public void printLine(String s) {
        try {
            os.write(s.getBytes());
        } catch (IOException e) {
            System.err.println("Error! Write to file is not available");
            System.err.println(e.getMessage());
        }
    }

    public String readLine(byte[] b) {
        try {
            is.read(b);
        } catch (IOException e) {
            System.err.println("Error! Read to file is not available");
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Error! array b is null");
            System.err.println(e.getMessage());
        }
        return new String(b, StandardCharsets.UTF_8);
    }
}
