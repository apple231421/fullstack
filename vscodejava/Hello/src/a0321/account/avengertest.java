package a0321.account;

public class avengertest {
    public static void main(String[] args) {
        avenger ironman = new avenger("아이언맨", 100, 120);
        avenger hulk = new avenger("헐크", 200, 80);
        // 객체 정보출력
        System.out.println(ironman.toStr());
        System.out.println(hulk.toStr());
    }
}

class avenger {
    private String name;
    private int power;
    private int speed;

    public avenger(String name, int power, int speed) {
        this.name = name;
        this.power = power;
        this.speed = speed;
    }

    String toStr() {
        return String.format("avenger{name : %s, power : %d, speed:%d}", name, power, speed);
    }

}
