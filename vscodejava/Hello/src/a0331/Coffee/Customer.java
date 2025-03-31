package a0331.Coffee;

import java.util.Map;

public class Customer {
    private int orderNum;
    private int money;

    private Map<String, Integer> coffeeOrder;
    // 고객이 주문한 커피의 종류와 수량 저장하는 맵
    // EX) 아메리카노2, 카푸치노3

    public Customer(int orderNum) {
        this.orderNum = orderNum;
        this.money = 20000; // 고객이 가지고 있는 돈(초기값 20000)
    }

    public Map<String, Integer> getCoffeeOrder() {
        return coffeeOrder;
    }

    public void setCoffeeOrder(Map<String, Integer> coffeeOrder) {
        this.coffeeOrder = coffeeOrder;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getOrderName() {
        return "고객 " + orderNum;
    }

}
