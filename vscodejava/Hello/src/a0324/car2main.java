package a0324;

public class car2main {
    public static void main(String[] args) {

        car2 c1 = new car2();
        car2 c2 = new car2("중형치");
        car2 c3 = new car2("현대", "대형차");
        car2 c4 = new car2("black", "기아", "화물차");

        System.out.println("c1 =" +c1.toString());
        System.out.println("c2 =" +c2);
        System.out.println("c3 =" +c3);
        System.out.println("c4 =" +c4);
    }
}
