package 영화애매;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import a0402.javaair.Flight;
import a0402.javaair.FlightManager;

public class movie {
    private movieManager mm = new movieManager();


    public void update(String string) {
        try {
            File file = new File("d:\\ticket\\schedule.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("=========================================");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] movie = line.split("/");
                movieManager.getmovies().add(
                        new movieInfo(movie[0], movie[1], Integer.parseInt(movie[2]), Boolean.parseBoolean(movie[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("schedule.txt 파일을 찾을수 없습니다");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패");
        }
    }

}
