package a0328.book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileClass {
    private File file; // 파일을 저장할 변수
    private String dir; // 파일이 저장될 디렉토리
    private String fileName; // 파일 이름

    // 기본 생성자: d:\ 경로에 파일을 저장
    public FileClass() {
        file = new File("d:\\");
    }

    // 디렉토리와 파일명을 받아서 파일 객체를 생성하는 생성자
    public FileClass(String dir, String fileName) {
        file = new File("d:\\" + dir + "\\" + fileName + ".txt");
        this.dir = "d:\\" + dir;
        this.fileName = fileName + ".txt";
    }

    // 파일이 존재하는지 확인하는 메서드
    private boolean check(File file) {
        if (file.exists()) { // 파일이 존재하면 true 반환
            return true;
        }
        return false; // 파일이 없으면 false 반환
    }

    // 파일을 생성하는 메서드
    public void create() throws Exception {
        boolean exist = check(file); // 파일이 있는지 체크
        if (exist) {
            file.delete(); // 파일이 있으면 삭제
            file.createNewFile(); // 새로 파일 생성
        } else {
            file = new File(dir); // 디렉토리 경로로 파일 객체 생성
            file.mkdir(); // 디렉토리 생성
            file = new File(dir + "\\" + fileName); // 디렉토리 내에 파일 객체 생성
            file.createNewFile(); // 새 파일 생성
        }
    }

    // 파일에 데이터를 쓰는 메서드
    public void write(String str) throws Exception {
        FileWriter fw = new FileWriter(file); // 파일을 쓰기 위한 FileWriter 객체 생성
        PrintWriter pw = new PrintWriter(fw); // PrintWriter 객체로 데이터를 출력
        pw.println(str); // 문자열을 한 줄로 출력
        fw.close(); // 파일쓰기 종료
    }

    // 파일을 읽는 메서드
    public void read() throws Exception {
        boolean exist = check(file); // 파일이 있는지 체크
        if (exist) {
            FileReader fr = new FileReader(file); // 파일을 읽기 위한 FileReader 객체 생성
            BufferedReader bw = new BufferedReader(fr); // BufferedReader로 파일을 효율적으로 읽음
            String str;
            while ((str = bw.readLine()) != null) { // 파일에서 한 줄씩 읽음
                System.out.println((str)); // 읽은 내용을 출력
            }
            bw.close(); // 파일 읽기 종료
        } else {
            System.out.println("읽을 파일이 없습니다."); // 파일이 없으면 에러 메시지 출력
        }
    }
}
