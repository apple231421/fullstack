package 렌트카;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;

public class Car {
    private String id;
    private String name;
    private String genre;

    private static final File file = new File("D:\\kimchanggyu\\vscodejava\\Hello\\src\\렌트카\\Carlist\\Carlist.txt");

    // 생성자
    public Car(String id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // 새로운 차량 등록용 생성자
    public Car(String name, String genre) {
        this.id = String.valueOf(Instant.now().getEpochSecond()); // String으로 변환
        this.name = name;
        this.genre = genre;
    }

    // Getter 메소드들
    public String getId() { return id; }
    public String getName() { return name; }
    public String getGenre() { return genre; }

    // 파일에 저장할 문자열 형식 생성
    private String toFileString() {
        return String.format("%s,%s,%s", id, name, genre); // genre가 아닌 name 사용
    }

    // 차량 정보 저장
    public void save() throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(this.toFileString() + "\n");
        }
    }

    // 모든 차량 정보 조회
    public static ArrayList<Car> findAll() throws IOException {
        ArrayList<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] temp = line.split(",");
                    if (temp.length == 3) {
                        Car c = new Car(temp[0], temp[1], temp[2]);
                        cars.add(c);
                    }
                } catch (Exception e) {
                    System.err.println("잘못된 데이터 형식: " + line);
                }
            }
        }
        return cars;
    }

    // 차량 삭제
    public static void delete(String carIdStr) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (!carIdStr.equals(temp[0])) {
                    text.append(line).append("\n");
                }
            }
        }
        
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(text.toString());
        }
    }

    // ID로 차량 검색
    public static Car findById(String carIdStr) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (carIdStr.equals(temp[0])) {
                    return new Car(temp[0], temp[1], temp[2]);
                }
            }
        }
        return null;
    }

    // toString 메소드 오버라이드
    @Override
    public String toString() {
        return String.format("차량ID: %s, 차종: %s, 종류: %s", id, name, genre);
    }
}