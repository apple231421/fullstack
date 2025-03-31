package a0331.Coffee;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeService {
    private boolean reOrder = false; // 고객의 추가 주문 여부
    private int orderNum = 1; // 고객주문 번호
    Map<String, Integer> orderList; // 주문내용(커피이름,수량)

    public CoffeeService() {
        orderList = new LinkedHashMap<>();
    }

    Coffee coffee = Coffee.getInstance(); // 커피메뉴 관리하는 싱글톤 객체
    Customer customer; // 손님 객체
    Thread t = new Thread(); // 지연 처리용 스레드
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("\n 어서오세요 더조은커피숍입니다.");
        customer = new Customer(orderNum); // 주문번호, 잔액(카드)
        coffee.getMenu(); // 메뉴판 출력
        order(); // 주문 메소드
        totalOrder(customer); // 총 주문 내역 출력 및 결제
       
    }

    private void end() {
        int s = 1;
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|           " + customer.getOrderName() + " 고객님 주문하신 음료 나왔습니다         | \n");
        System.out.print(message);
        for (Map.Entry<String, Integer> order : customer.getCoffeeOrder().entrySet()) {
            System.out.printf(" | [%d] %-20s : %2d잔  %7s |\n", s, order.getKey(), order.getValue(), "");
            s++;
        }
        System.out.println(" |                                                    |");
        System.out.println(" +----------------------------------------------------+");
    }

    private void order() {
        System.out.println("\n 취소를 원하시면 0번을 눌러주세요.");
        end: while (true) {
            try {
                System.out.print("\n 원하시는 음료의 번호를 선택해주세요 : ");
                String choice = sc.next();
                int choiceNum = Integer.parseInt(choice.substring(0, 1)); // 숫자 추출
                if (choiceNum == 0) {
                    System.out.println("주문을 취소합니다.");
                    System.exit(0); // 프로그램 종료
                }
                sc.nextLine(); // 불필요한 내용 삭제
                String coffeeName = coffee.coffeeList.get(choiceNum - 1); // 커피 이름 추출
                System.out.println("선택하신 음료는 : " + coffeeName + "입니다. 몇 잔 주문하시겠습니까?");
                int orderCount = sc.nextInt();
                sc.nextLine();

                // 기존 주문이 있는 경우
                if (reOrder) {
                    for (String coff : orderList.keySet()) {
                        if (coff.equals(coffeeName)) {
                            int addCount = orderList.get(coff) + orderCount; // 기존 수량에 추가
                            orderList.replace(coffeeName, addCount);
                        } else {
                            orderList.put(coffeeName, orderCount); // 새로 추가
                            break;
                        }
                    }
                } else {
                    orderList.put(coffeeName, orderCount); // 새로 추가
                }

                // 추가 주문 여부 확인
                addOrder();
                customer.setCoffeeOrder(orderList); // 고객의 주문 저장
                break end;

            } catch (Exception e) {
                System.out.println("잘못된 선택입니다. 다시 시도해주세요.");
                continue; // 잘못된 입력 시 재시도
            }
        }
    }

    private void addOrder() {
        reOrder = false;
        System.out.println("\n 주문을 계속하시겠습니까?");
        System.out.println("예(Y) / 아니오(N)");
        String yesOrNo = sc.next();
        if (yesOrNo.equals("예") || yesOrNo.equalsIgnoreCase("y")) {
            coffee.getMenu(); // 메뉴 재출력
            reOrder = true;
            order(); // 다시 주문 받기
        } else if (yesOrNo.equals("아니오") || yesOrNo.equalsIgnoreCase("n")) {
            return; // 주문 완료
        }
    }

    private void totalOrder(Customer customer) {
        int s = 1;
        int totalMoney = 0;
        DecimalFormat f = new DecimalFormat("###,000");
        String name = customer.getOrderName() + "번 ";
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|             " + name + "고객님 의 주문 내역 입니다         | \n");

        for (Map.Entry<String, Integer> order : customer.getCoffeeOrder().entrySet()) {
            String coffeeName = order.getKey();
            int orderCount = order.getValue();
            int coffeeUnitPrice = coffee.menu.get(coffeeName);
            int coffeePrice = coffeeUnitPrice * orderCount;
            totalMoney += coffeePrice;
            String pay = f.format(coffeePrice); // 가격 포맷팅
            message.append(String.format(" | [%d] %-20s : %2d잔  %7s |\n", s, coffeeName, orderCount, pay));
            s++;
        }

        message.append(" |                                                    |\n ")
                .append("+----------------------------------------------------+ \n")
                .append(" ============ 총 결제 금액은 " + f.format(totalMoney) + "입니다 ========== \n");
        System.out.println(message);
        payment(totalMoney); // 결제 진행
    }

    private void payment(int totalMoney) {
        System.out.println("결제를 도와 드리겠습니다. 카드를 넣어주세요.");
        int payResult = customer.getMoney() - totalMoney; // 결제 후 잔액 계산
        try {
            t.sleep(2500); // 2.5초 대기
            System.out.println("결제중입니다......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        if (payResult < 0) {
            System.out.println("잔액이 부족합니다.");
            return; // 잔액이 부족하면 후속 처리를 막고 종료

        } else {
            customer.setMoney(payResult); // 결제 후 잔액 갱신
            System.out.println("결제가 완료되었습니다.");
            System.out.println("이용해주셔서 감사합니다.");
            orderNum++; // 다음 고객 번호 증가
    
            // 결제가 완료되었을 때 음료 준비 메시지와 주문 내역을 출력
            try {
                System.out.println("기다려 주시면 주문하신 음료가 나옵니다.");
                t.sleep(2000); // 2초 후에 다음 문장이 실행됨
                end(); // 음료 준비 완료 메시지
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
