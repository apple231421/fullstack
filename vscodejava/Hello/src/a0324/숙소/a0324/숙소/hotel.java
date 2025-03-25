package a0324.숙소;

public class hotel {
    private String name; // 숙소 이름
    private String location; // 숙소 위치
    private double price; // 숙소 가격
    private boolean available; // 숙박 가능여부

    public hotel(){

    }
    public hotel(String name, String location, double price) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "숙소 이름 : " + name + ", 숙소 위치 : " + location + ", 숙소 가격 : " + price +
                ", 숙박 가능 여부 : " + (available ? "예약 가능" : "예약 중");
    }

    public void agoda() {
        this.available = false;
    }
}
