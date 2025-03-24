package a0324.doseo;

public class library {
    public static void main(String[] args) {
        
        // ebook 객체 생성
        ebook ebook = new ebook("이것이자바다", "신용권","2023-1113", 5.6, "pdf");
        printbook printbook = new printbook("천만나리액트", "이인제", "2022-2132",50, 0.8);
    

    // 도서정보 출력
    System.out.println("ebook information");
    ebook.displayinfo();
    System.out.println();
    System.out.println("print book information");
}
}
