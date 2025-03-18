package a0318;

// 원기둥의 부피 =  r * r * h * 3.14
public class ramyun {
    public static void main(String[] args) {
        buy();
        boil();
        put();
        eat();
        // 라면 사옴 물 끓임 라면 넣는다 맛있게 먹는다

    }

    public static void eat() {
        System.out.println("맛있게 먹는다");
    }

    public static void put() {
        System.out.println("라면을 넣는다");
    }

    public static void boil() {
        System.out.println("물을 끓인다");
    }

    public static void buy() {
        System.out.println("라면을 사온다");
    }

}