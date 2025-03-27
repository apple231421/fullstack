package a0327.mapEx;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEX  {
    public static void main(String[] args) {
        // 사용자 id와 password를 저장할 HashMap
        HashMap<String, String> map = new HashMap<>();
        map.put("house", "aaaA1234");
        map.put("house1", "1312");
        map.put("house2", "1406");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("id와 password를 입력해주세요");

            // id 입력 받기
            System.out.print("id : ");
            String id = sc.nextLine().trim();

            // 아이디가 존재하는지 확인
            if (!map.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력해주세요.");
                continue; // 아이디가 틀리면 다시 아이디부터 입력받기
            }

            // 비밀번호 입력 받기
            while (true) {
                System.out.print("password : ");
                String pw = sc.nextLine().trim();

                // 비밀번호가 맞는지 확인
                if (map.get(id).equals(pw)) {
                    System.out.println("로그인 되었습니다.");
                    return; // 로그인 성공시 종료
                } else {
                    System.out.println("틀린 비밀번호입니다. 다시 입력해주세요.");
                }
            }
        }
    }
}
