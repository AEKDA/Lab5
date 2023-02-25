package io;


public class Logger {

    private Logger() {
    }

    private static Logger log = null;

    public static Logger get() {
        if (log == null) {
            log = new Logger();
        }
        return log;
    }

    public void writeLine(String s) {
        System.out.println(s);
    }

    public void write(String s) {
        System.out.printf("%s", s);
    }
    public void write(String format, Object ...args) {
        System.out.printf(format, args);
    }
}
