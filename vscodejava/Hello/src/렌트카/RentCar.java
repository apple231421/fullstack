package 렌트카;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class RentCar {
    private long id; // 발급번호
    private long carId; // 차 대표값
    private String carName; // 차 이름
    private String carCount; // 차 수량
    private boolean isReturned; // 반납 여부

    private static final String DIRECTORY_PATH = "D:\\kimchanggyu\\vscodejava\\Hello\\src\\렌트카\\VIN.txt";
    private static final String FILE_NAME = "VIN";
    private static final File directory = new File(DIRECTORY_PATH);
    private static final File file = new File(directory, FILE_NAME);

    // 기존 생성자들
    public RentCar(long id, long carId, String carName, String carCount) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.carCount = carCount;
        this.isReturned = false;
    }

    public RentCar(long carId, String carName, String carCount) {
        this.id = Instant.now().toEpochMilli();
        this.carId = carId;
        this.carName = carName;
        this.carCount = carCount;
        this.isReturned = false;
    }

    // Getter 메소드들
    public long getId() {
        return id;
    }

    public long getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarcount() {
        return carCount;
    }

    public boolean isReturned() {
        return isReturned;
    }

    // 렌트 번호로 검색하는 새로운 메소드
    public static RentCar findByRentId(String rentId) throws IOException {
        if (!file.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (isValidData(temp) && temp[0].equals(rentId)) {
                    return new RentCar(
                            Long.parseLong(temp[0]),
                            Long.parseLong(temp[1]),
                            temp[2],
                            temp[3]);
                }
            }
        }
        return null;
    }

    // 차량 반납 처리
    public void returnCar() throws IOException {
        this.isReturned = true;
        updateRentStatus();
    }

    // 렌트 상태 업데이트
    private void updateRentStatus() throws IOException {
        List<String> fileContents = new ArrayList<>();
        boolean found = false;

        // 파일 내용 읽기
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] temp = line.split(",");
                    if (temp[0].equals(String.valueOf(this.id))) {
                        found = true;
                        continue; // 반납된 항목은 제외
                    }
                    fileContents.add(line);
                }
            }
        }

        // 파일 다시 쓰기
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : fileContents) {
                bw.write(line);
                bw.newLine();
            }
        }

        if (!found) {
            throw new IOException("해당 렌트 정보를 찾을 수 없습니다.");
        }
    }

    // 기존의 findByCarId 메소드
    public static ArrayList<RentCar> findByCarId(String carId) throws IOException {
        ArrayList<RentCar> rentCars = new ArrayList<>();

        if (!file.exists()) {
            return rentCars;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length >= 4 && temp[1].equals(carId)) {
                    RentCar rentCar = new RentCar(
                            Long.parseLong(temp[0]), // id
                            Long.parseLong(temp[1]), // carId
                            temp[2], // carName
                            temp[3] // carCount
                    );
                    rentCars.add(rentCar);
                }
            }
        } catch (NumberFormatException e) {
            throw new IOException("잘못된 데이터 형식입니다: " + e.getMessage());
        }

        return rentCars;
    }

    // 파일 저장
    public void save() throws IOException {
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            String data = String.format("%d,%d,%s,%s\n",
                    id, carId, carName, carCount);
            bw.write(data);
        }
    }

    private static boolean isValidData(String[] data) {
        return data != null && data.length >= 4 &&
                data[0] != null && !data[0].trim().isEmpty() &&
                data[1] != null && !data[1].trim().isEmpty() &&
                data[2] != null && !data[2].trim().isEmpty() &&
                data[3] != null && !data[3].trim().isEmpty();
    }

    public void markAsReturned() throws IOException {
        if (this.isReturned) {
            throw new IllegalStateException("이미 반납된 차량입니다.");
        }

        List<String> fileContents = new ArrayList<>();
        boolean found = false;

        // 파일 읽기
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] temp = line.split(",");
                    if (temp[0].equals(String.valueOf(this.id))) {
                        found = true;
                        // 반납된 항목은 저장하지 않음
                    } else {
                        fileContents.add(line);
                    }
                }
            }
        }

        // 파일 다시 쓰기
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String line : fileContents) {
                bw.write(line);
                bw.newLine();
            }
        }

        if (!found) {
            throw new IOException("해당 렌트 정보를 찾을 수 없습니다.");
        }

        this.isReturned = true;
    }

    // toString 메서드 수정
    @Override
    public String toString() {
        return String.format("발급번호: %d, 차량ID: %d, 차종: %s, 수량: %s, 상태: %s",
                id, carId, carName, carCount,
                isReturned ? "반납됨" : "대여중");
    }
}