package 렌트카;

import java.util.ArrayList;

public class Count {
    private int totalCount; // 총 차량 수
    private int rentedCount; // 대여된 차량 수
    private int availableCount; // 대여 가능한 차량 수
    private ArrayList<RentCar> rentCars;

    public Count(ArrayList<RentCar> rentCars) {
        this.rentCars = rentCars;
        this.totalCount = 10; // 초기 총 차량 수를 10대로 설정

        // rentCars가 null인 경우 처리
        if (rentCars == null) {
            this.rentedCount = 0;
        } else {
            this.rentedCount = totalRentedCount(rentCars);
        }

        this.availableCount = this.totalCount - this.rentedCount;
    }

    // 현재 대여된 총 수량 계산
    private int totalRentedCount(ArrayList<RentCar> rentCars) {
        int total = 0;
        for (RentCar car : rentCars) {
            if (car != null && !car.isReturned()) {
                String carCount = car.getCarcount();
                if (carCount != null && !carCount.trim().isEmpty()) {
                    try {
                        total += Integer.parseInt(carCount);
                    } catch (NumberFormatException e) {
                        System.err.println("잘못된 수량 형식: " + carCount);
                    }
                }
            }
        }
        return total;
    }

    // 차량 대여 처리
    public void markRented(int count) throws Exception {
        if (count <= 0) {
            throw new Exception("잘못된 대여 수량입니다.");
        }

        if (availableCount < count) {
            throw new Exception("대여 가능한 차량이 부족합니다. (가능 수량: " + availableCount + ")");
        }

        rentedCount += count;
        availableCount -= count;
    }

    // 차량 반납 처리
    public void returnCar(int count) throws Exception {
        if (count <= 0) {
            throw new Exception("잘못된 반납 수량입니다.");
        }

        if (rentedCount < count) {
            throw new Exception("대여된 수량보다 많은 수량을 반납할 수 없습니다.");
        }

        rentedCount -= count;
        availableCount += count;
    }

    // 현재 차량 현황 표시
    public void show() {
        System.out.println("--------------------");
        System.out.println(" R E N T C A R");
        System.out.println("--------------------");
        System.out.println("총 보유 차량: " + totalCount + "대");
        System.out.println("대여중인 차량: " + rentedCount + "대");
        System.out.println("대여 가능 차량: " + availableCount + "대");
        System.out.println("--------------------");
    }

    // 차량 대여 가능 여부 확인
    public boolean isAvailable(int count) {
        return count > 0 && availableCount >= count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getRentedCount() {
        return rentedCount;
    }

    public int getAvailableCount() {
        return availableCount;
    }
}