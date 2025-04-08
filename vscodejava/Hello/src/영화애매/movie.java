package 영화애매;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Map;

public class movie {

    private movieManager mm = new movieManager();

    public void initializeTicketFile() {
        try {
            // 티켓 정보를 저장할 파일 경로
            File file = new File("D:\\kimchanggyu\\vscodejava\\Hello\\src\\영화애매\\movielist\\ticket.txt");

            // 파일이 존재하지 않으면 파일 생성
            if (!file.exists()) {
                // 디렉터리가 존재하지 않으면 디렉터리 생성
                File dir = new File(file.getParent());
                if (!dir.exists()) {
                    dir.mkdirs(); // 디렉터리 없으면 생성
                }
                file.createNewFile(); // 파일을 생성
                System.out.println("새로운 티켓 파일을 생성했습니다.");
            }

            // 파일을 초기화: 덮어쓰기 모드로 열기
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false)); // false로 덮어쓰기
            bufferedWriter.write(""); // 파일 내용을 빈 문자열로 덮어쓰기
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("티켓 파일이 초기화되었습니다.");

        } catch (IOException e) {
            System.out.println("파일 초기화 실패: " + e.getMessage());
        }
    }

    public void ticketSaveFile(Map<String, movieInfo> reservationMap, String name) {
        // 예약자가 없는 경우 오류를 방지
        if (name == null || name.isEmpty()) {
            System.out.println("예약자 정보가 없습니다.");
            return; // 예약자가 없으면 함수를 종료
        }

        try {
            // 티켓 정보를 저장할 파일 경로
            File file = new File("D:\\kimchanggyu\\vscodejava\\Hello\\src\\영화애매\\movielist\\ticket.txt");

            // 티켓 정보를 파일에 저장하기 전에 기존 내용을 읽어 중복 여부를 확인
            String ticketInfo = mm.ticketPrint(reservationMap, name); // 새로 추가할 티켓 정보

            // 파일에서 기존 티켓 정보 읽기
            String existingTickets = readTicketsFromFile(file);

            // 중복이 없는 경우에만 추가
            if (!existingTickets.contains(ticketInfo)) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                if (file.isFile() && file.canWrite()) {
                    bufferedWriter.write(ticketInfo); // 티켓 정보를 파일에 씀
                    bufferedWriter.newLine(); // 새 줄에 작성
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    System.out.println("티켓 정보가 저장되었습니다.");
                }
            } else {
                System.out.println("중복된 티켓 정보입니다.");
            }
        } catch (IOException e) {
            System.out.println("파일 저장 실패: " + e.getMessage());
        }
    }

    // 파일에서 기존 티켓 정보를 읽는 메서드
    private String readTicketsFromFile(File file) {
        StringBuilder existingTickets = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                existingTickets.append(line).append("\n");
            }
        } catch (IOException e) {
            // 파일 읽기 오류 처리
            System.out.println("파일 읽기 실패");
        }

        return existingTickets.toString();
    }

    public void update(String string) {
        try {
            File file = new File("D:\\kimchanggyu\\vscodejava\\Hello\\src\\영화애매\\movielist\\movielist.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("=========================================");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] movie = line.split("/");
                movieManager.getmovies().add(
                        new movieInfo(movie[0], movie[1], Integer.parseInt(movie[2]),
                                Boolean.parseBoolean(movie[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("movielist.txt 파일을 찾을수 없습니다");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패");
        }
    }
}
