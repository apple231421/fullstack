package a0331.Coffee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Coffee {
    private static Coffee instance; // 싱글톤

    private Coffee() {
    }

    public static Coffee getInstance() {
        if (instance == null) {
            instance = new Coffee();
        }
        return instance;
    }

    ArrayList<String> coffeeList;
    ArrayList<Integer> coffeePrice;
    Map<String, Integer> menu; // [커피종류, 커피가격] {아메리카노,2000}

    public void getMenu() {
        menu = new LinkedHashMap<String, Integer>();
        coffeeList = new ArrayList<>();
        coffeePrice = new ArrayList<>();

        // 메뉴 데이터
        coffeeList.add("아메리카노");
        coffeeList.add("카푸치노");
        coffeeList.add("아이스 아메리카노");
        coffeeList.add("카라멜 마끼아또");
        coffeeList.add("카페라떼");
        coffeeList.add("카페모카");

        coffeePrice.add(2000);
        coffeePrice.add(4500);
        coffeePrice.add(2500);
        coffeePrice.add(4000);
        coffeePrice.add(3000);
        coffeePrice.add(3500);

        // 메뉴에 가격 추가
        for (int i = 0; i < coffeeList.size(); i++) {
            menu.put(coffeeList.get(i), coffeePrice.get(i));
        }

        // 메뉴판 출력
        DecimalFormat f = new DecimalFormat("0,000원"); // 가격 포맷
        StringBuffer st = new StringBuffer();
        st.append("\n\n")
                .append("+---------------------------------------------------+\n")
                .append("+------------------------메뉴판----------------------+\n")
                .append("|            Menu                   price           |\n")
                .append("+---------------------------------------------------+\n");
        System.out.println(st.toString());

        int s = 1;
        // 메뉴 출력
        for (Entry<String, Integer> get : menu.entrySet()) {
            System.out.printf("| [%d] %-30s %s |\n", s, get.getKey(), f.format(get.getValue()));
            s++;
        }
        // f.format(get.getValue()) 3000원 4000원
        System.out.println("+---------------------------------------------------+");
    }
}
