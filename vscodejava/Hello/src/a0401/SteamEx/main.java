package a0401.SteamEx;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 700),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 오름차순으로 정렬하여 출력
        practice1(transactions);
        // 2. 거래자가 근무하는 모든 도시를 중복없이 나열
        practice2(transactions);
        // 3. Cambridge에서 근무하는 모든 거래자를 찾아 이름순으로 나열
        practice3(transactions);
        // 4. Milan에 거래자가 있는가
        practice4(transactions);
        // 5. Cambridge에서 거주하는 모든자의 모든 트랜잭션 값을 출력하시오
        practice5(transactions);
        // 6. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오
        practice6(transactions);
        // 7. 최대값을 구하시오
        practice7(transactions);
        // 8. 최소값을 구하시오
        practice8(transactions);
    }

    private static void practice1(List<Transaction> transactions) {
        List<Transaction> result = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011) // 필터링: 2011년에 발생한 거래
                .sorted(Comparator.comparing(Transaction::getValue)) // 가치(value)로 오름차순 정렬
                // .sorted(Comparator.comparing(Transaction::getValue).reversed) 내림차순
                .collect(Collectors.toList()); // 결과를 리스트로 수집

        // 결과 출력
        System.out.println(result);

    }

    private static void practice2(List<Transaction> transactions) {
        List<String> result = transactions.stream()
                .map((tran) -> tran.getTrader().getCity()).distinct()
                .collect(Collectors.toList());
        System.out.println(result);
    }
    // tran(transactions) 객체를 입력받아서
    // .map(Transaction::getTrader) //각 거래에서 거래자 객체를 추출
    // .map(Trader::getCity) //각 거래자에서 도시정보추출

    private static void practice3(List<Transaction> transactions) {
        List<Trader> result = transactions.stream()
                .map(Transaction::getTrader) // 거래자 객체 추출
                .filter(trader -> "Cambridge".equals(trader.getCity())) // Cambridge에서 근무하는 거래자만 필터링
                .distinct() // 중복 거래자 제거
                .sorted(Comparator.comparing(Trader::getName)) // 이름순으로 정렬
                .collect(Collectors.toList()); // 결과 리스트로 수집

        // 결과 출력
        System.out.println("Cambridge에서 근무하는 거래자 목록:");
        result.forEach(System.out::println); // Improved output format
    }

    private static void practice4(List<Transaction> transactions) {
        boolean result = transactions.stream().anyMatch(tran -> "Milan".equals(tran.getTrader().getCity()));
        if (result == true) {
            System.out.println("Milan에서 거래하는 사람이 있다.");

        } else {
            System.out.println("Milan에서 거래하는 사람이 없다.");
        }
    }

    private static void practice5(List<Transaction> transactions) {
        List<Transaction> result = transactions.stream().filter(tran -> "Cambridge".equals(tran.getTrader().getCity()))
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static void practice6(List<Transaction> transactions) {
        List<String> result = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    private static void practice7(List<Transaction> transactions) {
        Transaction result = transactions.stream().max(Comparator.comparing(Transaction::getValue)).orElse(null);
        System.out.println(result);
    }

    private static void practice8(List<Transaction> transactions) {
        Optional<Transaction> result = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(result); // 값이 null이어도 Optional로 감싸서 반환
        System.out.println(result.get().getValue());
    }
}

// Trader 클래스
class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
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
        return name + " (" + city + ")";
    }
}

// Transaction 클래스
class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
