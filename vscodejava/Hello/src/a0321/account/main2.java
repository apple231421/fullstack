package a0321.account;

public class main2 {
    public static void main(String[] args) {

        student student1 = new student("홍길동", 2023151, 90, 85, 92);

        System.out.println("이름: " + student1.getName());
        System.out.println("학번: " + student1.getStudentid());
        System.out.println("국어: " + student1.getKor());
        System.out.println("수학: " + student1.getMath());
        System.out.println("영어: " + student1.getEng());
        System.out.println("평균: " + student1.getaverage());
        System.out.println("합: " + student1.getsum()+"\n");

        student student2 = new student();
        student2.setName("이경자");
        student2.setStudentid(2000000);
        student2.setKor(90);
        student2.setMath(20);
        student2.setEng(85);

        System.out.println("이름: " + student2.getName());
        System.out.println("학번: " + student2.getStudentid());
        System.out.println("국어: " + student2.getKor());
        System.out.println("수학: " + student2.getMath());
        System.out.println("영어: " + student2.getEng());
        System.out.println("평균: " + student2.getaverage());
        System.out.println("합: " + student2.getsum());
    }
}
