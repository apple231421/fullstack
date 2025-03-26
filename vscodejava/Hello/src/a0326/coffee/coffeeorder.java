package a0326.coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class coffeeorder {
    public static void main(String[] args) {
        // Coffee menu with prices
        Map<String, Integer> menu = new HashMap<>();
        menu.put("americano", 3000);
        menu.put("Latte", 4000);
        menu.put("Mocha", 4500);
        menu.put("Espresso", 2500);

        // Map to hold the user's order
        Map<String, Integer> order = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // Display the menu
            System.out.println("\n메뉴 : ");
            for (Map.Entry<String, Integer> entry : menu.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " 원");
            }

            // Prompt the user for an order
            System.out.print("주문할 커피 이름(종료:exit):\n");
            String coffee = sc.nextLine();

            if (coffee.equalsIgnoreCase("exit")) {
                break;  // Exit the loop if the user types "exit"
            }

            // Check if the coffee is on the menu
            if (!menu.containsKey(coffee)) {
                System.out.println("해당 커피는 메뉴에 없습니다. 다시 입력해주세요.");
                continue;  // Ask for a coffee again if it's not on the menu
            }

            // Input for quantity
            int quantity = 0;
            while (true) {
                System.out.print("수량을 입력해주세요: ");
                try {
                    quantity = Integer.parseInt(sc.nextLine());
                    if (quantity <= 0) {
                        System.out.println("수량은 1 이상이어야 합니다. 다시 입력해주세요.");
                        continue;
                    }
                    break;  // Valid input, exit the loop
                } catch (NumberFormatException e) {
                    System.out.println("유효한 숫자를 입력해주세요.");
                }
            }

            // Add the ordered coffee to the order map
            order.put(coffee, order.getOrDefault(coffee, 0) + quantity);
            System.out.println(coffee + " " + quantity + "개 추가 되었습니다.");
        }

        // Print the order summary and calculate total price
        sc.close();
        int total = 0;
        if (order.isEmpty()) {
            System.out.println("주문이 없습니다.");
        } else {
            System.out.println("\n주문 내역: ");
            for (Map.Entry<String, Integer> entry : order.entrySet()) {
                int price = menu.get(entry.getKey()) * entry.getValue();
                System.out.println(entry.getKey() + " X " + entry.getValue() + " = " + price + " 원");
                total += price;
            }
            System.out.println("총 금액: " + total + " 원");
        }
    }
}
