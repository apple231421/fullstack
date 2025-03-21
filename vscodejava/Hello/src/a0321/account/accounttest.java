package a0321.account;

public class accounttest {
    public static void main(String[] args) {

        account acc = new account();
        // acc.balance = 1000;
        // System.out.printf("잔액: %d", acc.balance);
        acc.setBalance(1000);
        System.out.printf("잔액 : %d",acc.getBalance());
            }
        }
        
        class account {
            // 자신외 모든 클래스의 접근을 거부한다
            private int balance;

            public int getBalance() {
                return balance;
            }

            public void setBalance(int balance) {
                this.balance = balance;
            }
        
}