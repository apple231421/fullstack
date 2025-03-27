

public class class3 {
    public static void main(String[] args) {
        System.out.println("card.width = " + card.width);
        System.out.println("card.width = " + card.height);
        // card.width, card.height 클래스 변수여서

        // 객체 생성후 참조변수 c1을 사용
        card c1 = new card();
        c1.kind = "heart";
        c1.num = 7;

        card c2 = new card();
        c2.kind = "spade";
        c2.num = 5;
        System.out.println("c1. = " + c1.kind + " , " + c1.num + "이며, 크기는 " + c1.width + ", " + c1.height);
        System.out.println("c2. = " + c2.kind + " , " + c2.num + "이며, 크기는 " + c2.width + ", " + c2.height);

        System.out.println("c1의 width와 height 50 ,80으로 변경합니다");
        // c1.width = 50;
        // c1.height = 80;
        card.width=50;
        card.height=80;
        System.out.println("c1. = " + c1.kind + " , " + c1.num + "이며, 크기는 " + c1.width + ", " + c1.height);
        System.out.println("c2. = " + c2.kind + " , " + c2.num + "이며, 크기는 " + c2.width + ", " + c2.height);
    }
}

class card {
    String kind; // 인스턴스 변수
    int num;
    static int width = 100;
    static int height = 80;
}
