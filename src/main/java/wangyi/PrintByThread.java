package wangyi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class PrintByThread {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter(new File("input.txt"));
            for (int i = 0; i < 10000; i++) {
                pw.print((int)(Math.random()*100) + ",");
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
