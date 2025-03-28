package a0328.file1;

import java.io.File;

public class FileInfo {
    public static void main(String[] args) {
        File file = new File("d:\\abc\\out.txt");

        // 파일정보
        System.out.println("파일이름 :"+ file.getName());
        System.out.println("파일이름 :"+ file.getAbsolutePath());
        System.out.println("파일이름 :"+ file.exists());
    }
}
