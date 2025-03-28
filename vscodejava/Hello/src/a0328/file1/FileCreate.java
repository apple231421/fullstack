package a0328.file1;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class FileCreate {
    public static void main(String[] args) {
        File file = new File("d\\testFolder\\extample.txt");

        try {
            File dir = file.getParentFile(); // 파일의 부모디렉토리 가져오기
            if (!dir.exists()) {
                dir.mkdirs(); // 폴더 없으면 생성
                System.out.println("폴더 생성 : " + dir.getAbsolutePath());
            }
            if (file.createNewFile()) {
                System.out.println("파일 생성됨 : " + file.getAbsolutePath());
            } else {
                System.out.println("파일이 존재함");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
