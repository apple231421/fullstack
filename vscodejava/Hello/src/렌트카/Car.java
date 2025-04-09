package 렌트카;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

import a0317.break1;

public class Car {
    private long id;
    private String name; // 차 이름
    private String genre; // 차 종류

    public Car(long id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Car(String name, String genre) {
        this.id = Instant.now().getEpochSecond(); // 타임스탬프
        this.name = name;
        this.genre = genre;
    }

    private static final File file = new File("D:\\kimchanggyu\\vscodejava\\Hello\\src\\렌트카\\Carlist\\Carlist.txt");

    public void save() throws IOException {
        FileWriter fw = new FileWriter(file, true);
        // 이어쓰기(append) 모드 설정 (true)
        fw.write(this.toFileString() + "\n");
        fw.close();
    }

    private String toFileString() {
        return String.format("%d,%s,%s", id, genre, genre);
    }

    public static ArrayList<Car> findAll() throws IOException {
        ArrayList<Car> cars = new ArrayList<Car>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");
            Car c = new Car(
                    Long.parseLong(temp[0]),
                    temp[1],
                    temp[2]);
            cars.add(c);
        }
        br.close();
        return cars;
    }

    public static void delete(String carIdStr) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text = "";
        String line = null;

        while ((line = br.readLine()) != null) {
            String[] temp = line.split(",");
            if (carIdStr.equals(temp[0])) {
                continue;
            }
            text += line + "\n";
        }
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
    }

    public static Car findById(String carIdStr) throws IOException {
        Car car = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] temp= line.split(",");
            if (carIdStr.equals(temp[0])) {
                car = new Car(Long.parseLong(temp[0]),temp[1],temp[2]);
                break;
            }
        }
        br.close();
        return car;
    }

}
