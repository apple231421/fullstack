package 렌트카;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;

// 차량(Car) 정보를 다루는 클래스
public class Car {
    private String id; // 차량 ID (고유값)
    private String name; // 차량 이름 (차종)
    private String genre; // 차량 종류 (예: SUV, 세단 등)

    // 차량 정보를 저장하는 파일 경로 설정
    private static final File file = new File("D:\\kimchanggyu\\vscodejava\\Hello\\src\\렌트카\\Carlist.txt");

    // 정적 블록: 프로그램 시작 시 파일과 디렉토리 자동 생성
    static {
        try {
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs(); // 디렉토리 생성
            }

            if (!file.exists()) {
                file.createNewFile(); // 파일 생성
            }
        } catch (IOException e) {
            System.err.println("파일 또는 디렉토리 생성 실패: " + e.getMessage());
        }
    }

    // 파일에서 불러올 때 사용하는 생성자
    public Car(String id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // 신규 등록용 생성자: 고유 ID를 현재 시간(밀리초)로 생성
    public Car(String name, String genre) {
        this.id = String.valueOf(Instant.now().toEpochMilli());
        this.name = name;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    // 차량 정보를 파일에 저장할 문자열 포맷
    private String toFileString() {
        return String.format("%s,%s,%s", id, name, genre);
    }

     // 기본 차량 목록 초기화 (중복 ID 방지용 sleep 추가)
     public static void maincar() throws IOException, InterruptedException {
        ArrayList<Car> cars = findAll();
        if (cars.isEmpty()) {
            System.out.println(">> 기본 차량 데이터를 초기화합니다.");

            new Car("아반떼", "세단").save();
            Thread.sleep(2);

            new Car("카니발", "RV").save();
            Thread.sleep(2);

            new Car("소나타", "세단").save();
            Thread.sleep(2);

            new Car("람보르기니", "슈퍼카").save();
            Thread.sleep(2);

            new Car("붕붕이", "어린이자동차").save();
        }
    }

    // 차량 정보를 파일에 저장
    public void save() throws IOException {
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs(); // 디렉토리가 삭제됐을 경우 대비
        }

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(this.toFileString() + "\n");
        }
    }

   

    // 파일에서 모든 차량 목록 불러오기
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

    // 차량 ID로 특정 차량 삭제
    public static void delete(String carIdStr) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (!carIdStr.equals(temp[0])) {
                    text.append(line).append("\n"); // 삭제 대상이 아니면 유지
                }
            }
        }

        // 파일 덮어쓰기
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(text.toString());
        }

        // 차량 삭제 시 해당 차량의 렌트 기록도 같이 삭제
        RentCar.deleteByCarId(carIdStr);
    }

    // 차량 ID로 검색
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
        return null; // 찾지 못했을 경우
    }

    // 차량 정보 출력용 toString() 오버라이드
    @Override
    public String toString() {
        return String.format("차량ID: %s, 차종: %s, 종류: %s", id, name, genre);
    }

    
}
