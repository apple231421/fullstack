package a0321.account;

public class coffeetest {
    public static void main(String[] args) {
        coffee c = new coffee("아메리카노", 3000);
        System.out.printf("%s(%d)->", c.getName(), c.getPrice());
        c.setPrice(c.getPrice() + 500);
        System.out.printf("%s(%d)", c.getName(), c.getPrice());
    }
}

class coffee {
    private String name;
    private int price;

    public coffee(String n, int p) {
        name = n;
        price = p;
    }

    public void setPrice(int p) {
        price = p;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
