package a0324.숙소;

import java.util.ArrayList;
import java.util.Scanner;

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
        if (hotellocation.isEmpty()) { // hotellocation 리스트가 비어있는지 체크
            System.out.println("예약된 숙소가 없습니다.");
        } else {
            for (hotel borrowhotel : hotellocation) {
                System.out.println(borrowhotel);
            }
        }
    }

    // 4번
    public void addagoda(String newname, String newlocation, Double newprice) {
        hotels.add(new hotel(newname, newlocation, newprice));
    }

    // 5번
    public void deagoda(String dname) {
        boolean result = false;
        hotel targetHotel = null;

        // 숙소명이 일치하는 숙소를 찾기
        for (hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(dname)) {
                targetHotel = hotel;
                break;
            }
        }

        // 숙소명이 존재하지 않을 경우
        if (targetHotel == null) {
            System.out.println(dname + " 라는 숙소명은 없습니다.");
            System.out.println();
            return;
        }

        // 숙소가 예약되었는지 확인
        if (!targetHotel.isAvailable()) {
            System.out.println("예약한 숙소 (" + dname + ") 는 삭제할 수 없습니다.");
            System.out.println();
            return;
        }

        // 삭제할 숙소가 예약되지 않은 경우 삭제
        if (targetHotel != null && targetHotel.isAvailable()) {
            hotels.remove(targetHotel);
            System.out.println("숙소 삭제 완료");
            System.out.println();
        }
    }

    // 6번

    public void updateagoda(String uname) {
        int index = -1;
        int menu = -1;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        hotel newhotel = new hotel();
        System.out.println();

        for (int i = 0; i < hotels.size(); i++) {
            hotel h = hotels.get(i);
            if (h.getName().equalsIgnoreCase(uname)) {
                index = i;
                newhotel = h;
            }
        }

        if (index != -1) {
            while (flag) {
                System.out.println("무엇을 수정하겠습니까");
                System.out.println("1.숙박 이름 \t 2.숙박 위치\t 3.숙박 가격");
                System.out.print(">> ");
                menu = sc.nextInt();
                sc.nextLine();

                switch (menu) {
                    case 1:
                        System.out.println("수정할 숙박 이름을 적으세요");
                        newhotel.setName(sc.nextLine());
                        hotels.set(index, newhotel);
                        flag = false;
                        break;
                    case 2:
                        System.out.println("수정할 숙박 위치을 적으세요");
                        newhotel.setLocation(sc.nextLine());
                        hotels.set(index, newhotel);
                        flag = false;
                        break;
                    case 3:
                        System.out.println("수정할 숙박 가격을 적으세요");
                        newhotel.setPrice(sc.nextDouble());
                        hotels.set(index, newhotel);
                        flag = false;
                        break;
                    default:
                        System.out.println("잘못된 번호입니다. 다시입력해주세요");
                        break;
                }

            }

        } else {
            System.out.println("해당 숙박을 찾을 수 없습니다.");
        }
    }
    // 7번

    public void showhotel(String sname) {
        boolean found = false; // 숙소를 찾았는지 여부를 추적하는 변수

        for (hotel h : hotels) {
            if (h.getName().equalsIgnoreCase(sname)) {
                System.out.println(h.toString()); // 숙소를 찾았을 때 출력
                found = true; // 숙소를 찾은 상태로 설정
                break; // 숙소를 찾으면 반복문 종료
            }
        }

        // 숙소를 찾지 못한 경우
        if (!found) {
            System.out.println("일치하는 숙박명이 없습니다.");
        }
    }

}