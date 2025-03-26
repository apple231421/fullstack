package a0326.coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class coffeeEx {
    public static void main(String[] args) {

        Map<String, Integer> menu = new HashMap<>();
        menu.put("americano", 3000);
        menu.put("Latte", 4000);
        menu.put("Mocha", 4500);
        menu.put("Espresso", 2500);

        Map<String, Integer> order = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("몇 명의 주문을 받으시겠습니까?");
        int human = Integer.parseInt(sc.nextLine());

        // 주문 받기
        for (int i = 0; i < human; i++) {

            while (true) {
                System.out.println();
                System.out.println((i + 1) + "번째 손님 주문을 시작합니다.");
                System.out.println("\n메뉴: ");
                for (Map.Entry<String, Integer> entry : menu.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue() + " 원");
                }

                System.out.print("주문할 커피 이름\n");
                String coffee = sc.nextLine();
                System.out.println();
                

                if (!menu.containsKey(coffee)) {
                    System.out.println("해당 커피는 메뉴에 없습니다. 다시 입력해주세요.");
                    continue;
                }

                int quantity = 0;
                while (true) {
                    System.out.print("수량을 입력해주세요: ");
                    try {
                        quantity = Integer.parseInt(sc.nextLine());
                        if (quantity <= 0) {
                            System.out.println("수량은 1 이상이어야 합니다. 다시 입력해주세요.");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력해주세요.");
                    }
                }

                // 주문에 커피와 수량 추가
                order.put(coffee, order.getOrDefault(coffee, 0) + quantity);
                System.out.println(coffee + " " + quantity + "개 추가 되었습니다.");
                System.out.println();
                break;
            }

        }

        // 총 금액 계산
        int total = 0;
        System.out.println("\n주문 내역: ");
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            int price = menu.get(entry.getKey()) * entry.getValue();
            System.out.println(entry.getKey() + " X " + entry.getValue() + " = " + price + " 원");
            total += price;
        }
        if (total < 19999) {

            System.out.println("고객님께서는 20000원 이상 구매를 못하셔서 할인을 받을수 없습니다 ㅠㅠ");
            System.out.println("할인된 금액: 0원");
            System.out.println("총 금액 : " + total + "원");
        } else {

            System.out.println("20000원 이상 구매시 총 가격에 10%할인해드립니다");
            System.out.println("할인된 금액: " + (total * 0.1) + "원");
            System.out.println("총 금액 : " + (total - (total * 0.1)) + "원");
        }
    }

}
