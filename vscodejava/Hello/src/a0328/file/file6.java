package a0328.file;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class file6 {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[1024];
        FileInputStream input = new FileInputStream("d:\\out.txt");
        input.read(b);
        System.out.println(new String(b));
        input.close();
    }
}
