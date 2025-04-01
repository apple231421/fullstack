package a0401.order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Kim", "Seoul");
        Customer customer2 = new Customer("Lee", "Busan");
        Customer customer3 = new Customer("Park", "Seoul");
        Customer customer4 = new Customer("Choi", "Seoul");

        List<Order> orders = Arrays.asList(
                new Order(1, customer1, "Laptop", 1),
                new Order(2, customer2, "Smartphone", 2),
                new Order(3, customer3, "Keyboard", 1),
                new Order(4, customer1, "Mouse", 3),
                new Order(5, customer4, "Monitor", 1),
                new Order(6, customer3, "USB Cable", 2));

        // 문제 1 서울에 사는 고객의 주문만 출력하시오.
        System.out.println("1. 서울에 사는 고객의 주문만 출력하시오.");
        problem1(orders);
        System.out.println();

        // 문제 2 모든 주문의 총 수량을 구하시오.(mapToInt사용)
        System.out.println("2. 모든 주문의 총 수량을 구하시오");
        problem2(orders);
        System.out.println();

        // 문제 3 각 고객의 이름과 그 고객이 주문한 제품명을 출력하시오.
        System.out.println("3. 고객의 이름과 그 고객이 주문한 제품명을 출력하시오");
        problem3(orders);
        System.out.println();

        // 문제 4 정 고객("Kim")의 주문만 필터링하여 출력하시오.
        System.out.println("4. 고객(\"Kim\")의 주문만 필터링하여 출력하시오");
        problem4(orders);
        System.out.println();

        // 문제 5 주문 수량이 2개 이상인 주문만 출력하시오.
        System.out.println("5. 주문 수량이 2개 이상인 주문만 출력하시오.");
        problem5(orders);
        System.out.println();

        // 문제 6 고객이 주문한 제품의 종류를 중복 없이 출력하시오.
        System.out.println("6. 고객이 주문한 제품의 종류를 중복 없이 출력하시오.");
        problem6(orders);
        System.out.println();

        // 문제 7 모든 주문을 quantity 기준 내림차순으로 정렬하시오.
        System.out.println("7. 모든 주문을 quantity 기준 내림차순으로 정렬하시오.");
        problem7(orders);
        System.out.println();

        // 문제 8각 도시별로 고객 수를 출력하시오. (count이용)
        System.out.println("8. 각 도시별로 고객 수를 출력하시오.");
        problem8(orders);

    }

    private static void problem1(List<Order> orders) {
        List<Order> result = orders.stream().filter(ord -> "Seoul".equals(ord.getCustomer().getCity()))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static void problem2(List<Order> orders) {
        int totalQuantity = orders.stream().mapToInt(Order::getQuantity).sum();
        System.out.println(totalQuantity);
    }

    private static void problem3(List<Order> orders) {
        List<String> result = orders.stream()
                .map(order -> order.getCustomer().getName() + " " + order.getProduct()) // 고객 이름과 제품 정보를 하나의 문자열로 결합
                .collect(Collectors.toList()); // 결과를 리스트로 수집

        // 결과 출력
        result.forEach(System.out::println);
    }

    private static void problem4(List<Order> orders) {
        List<String> result = orders.stream().filter(ord -> "Kim".equals(ord.getCustomer().getName()))
                .map(Order::getProduct)
                .collect(Collectors.toList());
        System.out.println("KIM 고객님들이 수문하신 제품 : " + result);
    }

    private static void problem5(List<Order> orders) {
        List<Order> result = orders.stream().filter(ord -> ord.getQuantity() >= 2)
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static void problem6(List<Order> orders) {
        List<String> result = orders.stream().map((ord) -> ord.getProduct()).distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void problem7(List<Order> orders) {
        List<Order> result = orders.stream()
                .distinct()
                .sorted(Comparator.comparing(Order::getQuantity).reversed())
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static void problem8(List<Order> orders) {
        long result = orders.stream()
                .map(Order::getCustomer)
                .filter(ord -> "Seoul".equals(ord.getCity()))
                .distinct()
                .count();
        long result1 = orders.stream()
                .map(Order::getCustomer)
                .filter(ord -> "Busan".equals(ord.getCity()))
                .distinct()
                .count();
        System.out.println("서울 고객수 : " + result + "  부산 고객수 : " + result1);
    }
}

class Customer {
    private final String name;
    private final String city;

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Order {
    private final int id;
    private final Customer customer;
    private final String product;
    private final int quantity;

    public Order(int id, Customer customer, String product, int quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
