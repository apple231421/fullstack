package a0324.숙소;

import java.util.ArrayList;

import a0324.book1.library;

public class hotelmanager {
    private ArrayList<hotel> hotels; // hotel을 객체를 리스트(묶음으로 저장가능)
    private ArrayList<hotel> hotellocation; // hotel을 객체중 숙박 가능한 객체를 저장하는 리스트

    // 1번
    public hotelmanager() {
        hotels = new ArrayList<>(); // 숙박 전체
        hotellocation = new ArrayList<>(); // 숙박가능한 목록
        hotels.add(new hotel("Hotel A", "Seoul", 100.0));
        hotels.add(new hotel("Hotel B", "Busan", 80.0));
        hotels.add(new hotel("Hotel C", "Jeju", 120.0));

    }

    // 2번
    public void allhotel() {
        for (hotel hotel : hotels) {
            if (hotel.isAvailable()) {
                System.out.println(hotel);
            }
        }
    }

    // 3번
    public boolean hotellocations(String hotelname) {
        for (hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(hotelname) && hotel.isAvailable()) {
                hotel.agoda(); // 숙박 불가능 Available에 = false 넣어주는 메서드
                hotellocation.add(hotel);
                return true;
            }
        }
        return false;
    }

    public void hotellocation() {
        for (hotel borrowhotel : hotellocation) {
            System.out.println(borrowhotel);
        }
    }

    // 4번
    public void addagoda(String newname, String newlocation, Double newprice) {
        hotels.add(new hotel(newname, newlocation, newprice));
    }

}
