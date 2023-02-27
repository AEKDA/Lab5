package io;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

public class Cin {
    private Type type;
    private Scanner scanner;

    public Cin(InputStream is) {
        if (is == System.in) {
            type = Type.STD;
        } else {
            type = Type.FILE;
        }
        scanner = new Scanner(is);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Type getType() {
        return this.type;
    }

    public static enum Type {
        FILE, STD
    }

    public static void push(Cin cin) {
        cinStack.push(cin);
    }

    public static Cin peek() {
        return cinStack.peek();
    }

    public static Cin pop() {
        return cinStack.pop();
    }

    private static Stack<Cin> cinStack = new Stack<>();
}
