package 렌트카;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

// 렌트카 대여 기록을 관리하는 클래스
public class RentCar {
    private long id; // 렌트 발급번호 (고유)
    private long carId; // 차량 ID
    private String carName; // 차량 이름
    private String carCount; // 수량
    private boolean isReturned; // 반납 여부

    // 렌트 정보 저장 파일
    private static final File file = new File("D:\\kimchanggyu\\vscodejava\\Hello\\src\\렌트카\\VIN.txt");

    // 정적 초기화 블록: 파일 및 디렉토리 없으면 자동 생성
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

    // 전체 필드를 받아서 객체 생성 (파일 로딩 시 사용)
    public RentCar(long id, long carId, String carName, String carCount) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.carCount = carCount;
        this.isReturned = false;
    }

    // 신규 렌트카 대여 등록 시 사용되는 생성자
    public RentCar(long carId, String carName, String carCount) {
        this.id = Instant.now().toEpochMilli(); // 현재 시각을 ID로 사용
        this.carId = carId;
        this.carName = carName;
        this.carCount = carCount;
        this.isReturned = false;
    }

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

    // 렌트 번호(ID)로 렌트카 정보 검색
    public static RentCar findByRentId(String rentId) throws IOException {
        if (!file.exists())
            return null;

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
        updateRentStatus(); // 파일에서 반납 상태 갱신
    }

    // 렌트 상태 업데이트 (반납 처리된 항목 제외하고 다시 저장)
    private void updateRentStatus() throws IOException {
        List<String> fileContents = new ArrayList<>();
        boolean found = false;

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] temp = line.split(",");
                    if (temp[0].equals(String.valueOf(this.id))) {
                        found = true; // 반납 대상
                        continue; // 제외
                    }
                    fileContents.add(line); // 유지할 기록
                }
            }
        }

        // 파일 다시 저장
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

    // 차량 ID로 대여된 기록을 모두 가져오기
    public static ArrayList<RentCar> findByCarId(String carId) throws IOException {
        ArrayList<RentCar> rentCars = new ArrayList<>();

        if (!file.exists())
            return rentCars;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (temp.length >= 4 && temp[1].equals(carId)) {
                    RentCar rentCar = new RentCar(
                            Long.parseLong(temp[0]),
                            Long.parseLong(temp[1]),
                            temp[2],
                            temp[3]);
                    rentCars.add(rentCar);
                }
            }
        } catch (NumberFormatException e) {
            throw new IOException("잘못된 데이터 형식입니다: " + e.getMessage());
        }

        return rentCars;
    }

    // 렌트카 기록 저장
    public void save() throws IOException {
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs(); // 디렉토리 생성
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            String data = String.format("%d,%d,%s,%s\n",
                    id, carId, carName, carCount);
            bw.write(data);
        }
    }

    // 데이터 유효성 검사
    private static boolean isValidData(String[] data) {
        return data != null && data.length >= 4 &&
                !data[0].trim().isEmpty() &&
                !data[1].trim().isEmpty() &&
                !data[2].trim().isEmpty() &&
                !data[3].trim().isEmpty();
    }

    // 반납 처리: 해당 렌트 기록을 제거
    public void markAsReturned() throws IOException {
        if (this.isReturned) {
            throw new IllegalStateException("이미 반납된 차량입니다.");
        }

        List<String> fileContents = new ArrayList<>();
        boolean found = false;

        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] temp = line.split(",");
                    if (temp[0].equals(String.valueOf(this.id))) {
                        found = true; // 해당 렌트 기록은 제거
                    } else {
                        fileContents.add(line); // 나머지 유지
                    }
                }
            }
        }

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

    // 차량 ID에 해당하는 모든 렌트 기록 삭제 (폐차 시 사용)
    public static void deleteByCarId(String carIdStr) throws IOException {
        List<String> remainingRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                if (!carIdStr.equals(temp[1])) {
                    remainingRecords.add(line);
                }
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String record : remainingRecords) {
                bw.write(record);
                bw.newLine();
            }
        }
    }

    // 출력용 문자열
    @Override
    public String toString() {
        return String.format("발급번호: %d, 차량ID: %d, 차종: %s, 수량: %s, 상태: %s",
                id, carId, carName, carCount,
                isReturned ? "반납됨" : "대여중");
    }
}
