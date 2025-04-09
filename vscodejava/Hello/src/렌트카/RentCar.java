package 렌트카;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

public class RentCar {

    private long id; // 발급번호
    private long carId; // 차 대표값
    private String carName; // 차 이름
    private String carcount; // 차 수량

    public RentCar(long id, long carId, String carName, String carcount) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.carcount = carcount;
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
        return carcount;
    }

    private static final File file = new File("D:\\kimchanggyu\\vscodejava\\Hello\\src\\렌트카\\Carlist\\VIN");

    public RentCar(long carId, String carName, String carcount) {
        this.id = Instant.now().toEpochMilli(); // 시간 스템프
        this.carId = carId;
        this.carName = carName;
        this.carcount = carcount;
    }

    public static ArrayList<RentCar> findByCarId(String carIdStr) throws IOException {
        ArrayList<RentCar> rentCars = new ArrayList<RentCar>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");
            if (carIdStr.equals(temp[1])) {
                long id = Long.parseLong(temp[0]); // 렌트 발급번호
                long carId = Long.parseLong(temp[1]);// 렌트카 대표값
                String carName = temp[2]; // 렌트카 종류
                String carcount = temp[3]; // 렌트카 수량
                RentCar c = new RentCar(id, carId, carName, carcount);
                rentCars.add(c);
            }

        }
        br.close(); // 입력 흐름 해제
        return rentCars;
    }

}
