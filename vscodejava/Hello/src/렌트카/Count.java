package 렌트카;

import java.util.ArrayList;

public class Count {
    public static final int MAX_ROW = 5;// 최대행의수
    public static final int MAX_COL = 5;// 최대열의수
    private String[][] map = new String[MAX_ROW][MAX_COL]; // 좌석의 예매 현황

    public Count(ArrayList<RentCar> rentCars) throws Exception {
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                map[i][j] = "O";
            }
        }
        for (int i = 0; i < rentCars.size(); i++) {
            RentCar c = rentCars.get(i);
            String carcount = c.getCarcount();
            mark(carcount);
        }
    }

}
