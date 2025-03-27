package a0327.mapEx;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx2 {
    public static void main(String[] args) {
        HashMap<Integer, String> fruit = new HashMap<>();
        fruit.put(1, "사과");
        fruit.put(2, "바나나");
        fruit.put(3, "복숭아");
        fruit.put(4, "딸기");
        System.out.println(fruit); // 전체가 다 나옴
        System.out.println(fruit.getOrDefault(1, "값이없습니다")); // key (1)값이 있으므로 사과를 출력
        System.out.println(fruit.getOrDefault(11, "값이없습니다")); // key 값이 없으므로 값이 없습니다 출력

        for (Map.Entry<Integer, String> entry : fruit.entrySet()) {
            System.out.println("[Key]: " + entry.getKey() + " [Value]: " + entry.getValue());

        }

        System.out.println();

        // for-each문 사용
        for (Integer i : fruit.keySet()) {
            System.out.println("[Key]: " + i + " [Value]: " + fruit.get(i));
        }

        System.out.println();

        Iterator<Map.Entry<Integer, String>> entries = fruit.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, String> entry = entries.next();
            System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
        }

        System.out.println();
        
        Iterator<Integer> keys = fruit.keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            System.out.println("[Key]:" + key + " [Value]:" + fruit.get(key));
        }
    }
}
