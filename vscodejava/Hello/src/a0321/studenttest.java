package a0321;

public class studenttest {
    public static void main(String[] args) {
        student park = new student(2019121245, "park");
        student kim = new student(2019123578, "kim");
        student seo = new student(2019547893, "seo");
        System.out.printf("student 객체의 수 : %d", student.count);
    }
}

class student {
    // 클래스 변수
    static int count = 0;

    // 인스턴스 변수
    int id;
    String name;

    // 생성자
    student(int i, String n) {
        student.count++;
        id = i;
        name = n;

    }
}