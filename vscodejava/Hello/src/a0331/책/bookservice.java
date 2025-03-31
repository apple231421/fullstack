package a0331.책;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class bookservice {

    private boolean ReBuy = false; // 추가 구매 여부
    private int BuyNum = -1; // 고객주문 번호
    Map<String, Integer> BuyList; // 구매내역(책이름,수량)

    public bookservice() {
        BuyList = new LinkedHashMap<>();
    }

    Book book = Book.getInstance(); // 책 관리하는 싱글톤 객체
    customer customer; // 손님 객체

    Thread t = new Thread(); // 지연 처리용 스레드
    Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("어서오세요 서점입니다");
        customer = new customer(BuyNum); // 주문번호, 잔액
        book.getMenu(); // 책 메뉴판 출력

        Buy(); // 책 구매 메서드
        totalBuy(customer); // 총 구매 내역 출력 및 결제
    }

    private void end() {
        int s = 1;
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|           " + customer.getOrderName() + " 고객님 주문하신 책이 나왔습니다         | " + "\n");
        System.out.print(message);

        // 주문 내역 출력
        for (Map.Entry<String, Integer> order : customer.getBookOrder().entrySet()) {
            System.out.printf(" | [%d] %-20s : %2d권  %7s |\n", s, order.getKey(), order.getValue(), "");
            s++;
        }
        System.out.println(" |                                                    |");
        System.out.println(" +----------------------------------------------------+");
    }

    private void Buy() {
        System.out.println("\n 취소를 원하시면 0번을 눌러주세요");
        while (true) {
            try {
                System.out.print("원하시는 책의 번호를 선택해주세요: ");
                String choice = sc.next();
                int choiceNum = Integer.parseInt(choice.substring(0, 1)); // 숫자 추출

                if (choiceNum == 0) {
                    System.out.println("주문을 취소합니다.");
                    System.exit(0); // 종료
                }

                sc.nextLine(); // 불필요한 내용 삭제
                String bookTitle = book.bookList.get(choiceNum - 1); // 선택된 책 이름
                System.out.println("선택하신 책은: " + bookTitle + "입니다. 몇 권 구매하시겠습니까?");
                int buyCount = sc.nextInt();

                // 추가 주문 처리
                if (ReBuy) {
                    for (String bb : BuyList.keySet()) {
                        if (bb.equals(bookTitle)) { // 이미 주문한 책이면
                            int addCount = BuyList.get(bb) + buyCount; // 기존 수량에 추가
                            BuyList.replace(bookTitle, addCount);
                        } else {
                            BuyList.put(bookTitle, buyCount);
                            break;
                        }
                    }
                } else {
                    BuyList.put(bookTitle, buyCount); // 새로운 책 주문
                }

                // 추가 주문 여부 처리
                addBuy();

                // 고객의 주문 정보를 설정
                customer.setBookOrder(BuyList);
                break;

            } catch (Exception e) {
                System.out.println("잘못된 선택입니다. 다시 시도해주세요");
                continue;
            }

        }

    }

    private void addBuy() {
        ReBuy = false;
        System.out.println("\n 구매를 계속하시겠습니까?");
        System.out.println("예(Y) / 아니요(N)");
        String yesOrno = sc.next();
        if (yesOrno.equals("예") || yesOrno.equalsIgnoreCase("y")) {
            book.getMenu();
            ReBuy = true;
            Buy();
        } else if (yesOrno.equals("아니요") || yesOrno.equalsIgnoreCase("n")) {
            return;
        }
    }

    private void totalBuy(customer customer2) {
        int s = 1;
        int totalMoney = 0;
        int bookPrice = 0;
        DecimalFormat b = new DecimalFormat("###,000");
        String name = customer.getOrderName() + "번 ";
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|             " + name + "고객님 의 주문 내역 입니다         | " + "\n");

        for (Map.Entry<String, Integer> Buy : customer.getBookOrder().entrySet()) {
            String bookTitle = Buy.getKey();
            int buyCount = Buy.getValue();
            int bookunitprice = book.menu.get(bookTitle);
            bookPrice = bookunitprice * buyCount;
            totalMoney = totalMoney + bookPrice;
            String pay = b.format(bookPrice);
            message.append(String.format(" | [%d] %-20s : %2d권  %7s |\n", s, bookTitle, buyCount, pay));
            s++;
        }

        message.append(" |                                                    |\n ")
                .append("+----------------------------------------------------+ \n")
                .append(" ============ 총 결제 금액은 " + b.format(totalMoney) + "입니다 ========== \n");

        // 1만원 이상 구매 시 10% 할인
        if (totalMoney >= 50000) {
            double discount = totalMoney * 0.1; // 10% 할인
            totalMoney = (int) (totalMoney - discount); // 할인 적용된 금액
            message.append("============만원 이상 구매시 10% 할인이됩니다.============\n");
            message.append(" ============ 10% 할인 금액은 " + discount + "입니다 ========== \n");
            message.append(" ============ 할인포함 총금액은 " + b.format(totalMoney) + "입니다 ========== \n");
        }

        System.out.println(message);
        payment(totalMoney); // 결제 진행
    }

    private void payment(int totalMoney) {
        System.out.println("결제를 도와드리겠습니다. 카드를 넣어주세요.");
        int payResult = customer.getMoney() - totalMoney;

        try {
            t.sleep(2000);
            System.out.println("결제중입니다.......");
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (payResult < 0) {
            System.out.println("잔액이 부족합니다.");
        } else {
            customer.setMoney(payResult);
            System.out.println("결제가 완료되었습니다");
            BuyNum++;
            try {
                t.sleep(2000);
                System.out.println("포장중이니 잠시만 기다려주세요");
                end();
                System.out.println("이용해주셔서 감사합니다");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
