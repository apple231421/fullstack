package a0328.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class file4 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("d:/out.txt");
        for (int i = 1; i < 11; i++) {
            String data = i + "번째 줄입니다.";
            fw.write(data);
        }

        // print 메서드 사용할 수 있다.
        fw.close();

        // 파일 추가 모드로 연다
        FileWriter fw2 = new FileWriter("d:/out.txt", true);
        for (int i = 11; i < 21; i++) {
            String data = i + "번째 줄입니다.";
            fw2.write(data);
        }

        // print 메서드 사용할 수 있다.
        fw2.close();
    }
}
