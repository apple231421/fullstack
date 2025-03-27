package a0327.mapEx;

import java.util.HashMap;

public class HashMapEx1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "사과");
        map.put(2, "바나나");
        map.put(3, "딸기");
        map.remove(1);  // 1번 사과 값이 제거 되고 나옴
        map.clear(); // 전체 값이 제거된다
        System.out.println(map);
        
    }
}
