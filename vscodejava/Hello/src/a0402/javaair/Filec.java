package a0402.javaair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Map;

public class Filec {
    private FlightManager fm = new FlightManager();

    public void ticketSaveFile(Map<String, Flight> reservationMap, String name) {
        try {
            File file = new File("d:\\ticket\\ticket.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            // BufferedWriter를 사용하여 file에 데이터를 쓸준비
            // FileWriter는 기본적으로 기존파일을 덮어씁니다.
            if (file.isFile() && file.canWrite()) {
                bufferedWriter.write(fm.ticketPrint(reservationMap, name)); // 티켓정보를 파일에 씀
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            System.out.println("파일저장실패");
        }
    }

    public void upload() {
        try {
            File file = new File("d:\\ticket\\schedule1.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("=========================================");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] flight = line.split("/");
                FlightManager.getFlights().add(new Flight(flight[0], flight[1],Integer.parseInt(flight[2]),Boolean.parseBoolean(flight[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("schedule1.txt 파일을 찾을수 없습니다");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패");
        }
    }

}
