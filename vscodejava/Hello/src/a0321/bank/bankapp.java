package a0321.bank;

import java.util.Scanner;

public class bankapp {

    private static account[] accountArray = new account[100];
    // 계좌 정보를 저장하는 배열 (static 사용으로 별도 인스턴스 생성 불필요)

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("--------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.이체 | 6.종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택>");
            int selnumber = Integer.parseInt(sc.nextLine());

            if (selnumber == 1) {
                creataccount();
            } else if (selnumber == 2) {
                accountlist();
            } else if (selnumber == 3) {
                deposit();
            } else if (selnumber == 4) {
                withdraw(); // 출금
            } else if (selnumber == 5) {
                post(); // 이체
            } else if (selnumber == 6) {
                run = false;
            }

        }
        System.out.println("프로그램을 종료합니다");
    }

    // 계좌생성 1
    private static void creataccount() {
        System.out.println("-----------");
        System.out.println("계좌생성");
        System.out.println("-----------");

        System.out.print("계좌번호 : ");
        String ano = sc.nextLine();

        System.out.print("계좌주 : ");
        String owner = sc.nextLine();

        System.out.print("초기입금액 : ");
        int balance = Integer.parseInt(sc.nextLine()); // 숫자로 받을거라 이렇게 사용

        account newAccount = new account(ano, owner, balance); // 키보드로 입력된 값을 생성자로 초기화한다.

        for (int i = 0; i < accountArray.length; i++) {

            // accountArray[i]방안에 값이 없으면 newAccount에 저장해라
            if (accountArray[i] == null) {
                accountArray[i] = newAccount;
                System.out.println("결과 : 계좌가 생성되었습니다");
                break;
            }
        }

        // accountArray[0]= newAccount("110-110","gildong",10000);
        // accountArray[1]= newAccount("110-111","sujin",10000);

    }

    
    // 계좌조회 2
    private static void accountlist() {
        System.out.println("-----------");
        System.out.println("계좌조회");
        System.out.println("-----------");
        for (int i = 0; i < accountArray.length; i++) {
            account account = accountArray[i];
            if (account != null) {
                System.out.print(account.getAno());
                System.out.print("       ");
                System.out.print(account.getOwner());
                System.out.print("       ");
                System.out.print(account.getBalance());
                System.out.println("원");
            }
        }
    }

    // 예금 3
    private static void deposit() {
        System.out.println("-----------");
        System.out.println("예금");
        System.out.println("-----------");
        System.out.println("계좌번호를 입력해주세요");
        String ano = sc.nextLine();
        System.out.println("입금금액을 입력해주세요");
        int money = Integer.parseInt(sc.nextLine());
        account account = findaccount(ano);

        if (account == null) {
            System.out.println("결과: 계좌가 없습니다");
            return;
        }
        account.setBalance(account.getBalance() + money);
        // 현재의 잔액을 getter로 불러와서 예금액(money)를 더한후
        // setBalance로 더한 금액을 넣기
    }

    // 계좌찾기
    private static account findaccount(String ano) {
        account account = null;
        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] != null) {
                String dbano = accountArray[i].getAno();// 배열의 계좌번호를 dbano에 둠
                if (dbano.equals(ano)) {
                    account = accountArray[i];
                    break;
                }
            }
        }
        return account;
    }

    // 출금 4
    private static void withdraw() {
        System.out.println("-----------");
        System.out.println("출금");
        System.out.println("-----------");
        System.out.println("계좌번호를 입력해주세요");
        String ano = sc.nextLine();
        System.out.println("출금금액을 입력해주세요");
        int money = Integer.parseInt(sc.nextLine());
        account account = findaccount(ano);
        account account2 = findaccount(ano);

        if (account == null) {
            System.out.println("결과: 계좌가 없습니다");
            return;
        }
        account.setBalance(account.getBalance() - money);
        // 현재의 잔액을 getter로 불러와서 예금액(money)를 뺀후
        // setBalance로 더한 금액을 저장

    }

    // 이체 5
    private static void post() {
        System.out.println("-----------");
        System.out.println("이체");
        System.out.println("-----------");

        // 출금 계좌 정보
        System.out.println("이체할 계좌번호를 입력해주세요");
        String ano = sc.nextLine();
        account account = findaccount(ano);
        // 출금 계좌가 없으면 종료
        if (account == null) {
            System.out.println("결과: 이체할 계좌번호가 없습니다");
            return;
        }

        System.out.println("이체금액을 입력해주세요");
        int money = Integer.parseInt(sc.nextLine());

        // 입금 받을 계좌정보
        System.out.println("입금을 받을 계좌번호를 입력해주세요");
        String ano1 = sc.nextLine();
        account account1 = findaccount(ano1);

        // 입금 계좌 없으면 종료
        if (account1 == null) {
            System.out.println("결과: 입금 받을 계좌가 없습니다");
            return;
        }

        // 출금 계좌 잔액
        account.setBalance(account.getBalance() - money);

        // 입금 계좌 잔액
        account1.setBalance(account1.getBalance() + money);

    }
}