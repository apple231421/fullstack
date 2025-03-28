package a0328.book;

public class bookDTO {
    // 책 정보 변수 선언
    private String title;  // 책 제목
    private String author;  // 저자
    private String ISBN;  // ISBN
    private double price;  // 가격

    // 기본 생성자
    public bookDTO() {
    }

    // 책 정보가 포함된 생성자
    public bookDTO(String title, String author, String iSBN, double price) {
        this.title = title;  // 책 제목
        this.author = author;  // 저자
        this.ISBN = iSBN;  // ISBN
        this.price = price;  // 가격
    }

    // 책 제목을 반환하는 메서드
    public String getTitle() {
        return title;
    }

    // 책 제목을 설정하는 메서드
    public void setTitle(String title) {
        this.title = title;
    }

    // 저자를 반환하는 메서드
    public String getAuthor() {
        return author;
    }

    // 저자를 설정하는 메서드
    public void setAuthor(String author) {
        this.author = author;
    }

    // ISBN을 반환하는 메서드
    public String getISBN() {
        return ISBN;
    }

    // ISBN을 설정하는 메서드
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    // 가격을 반환하는 메서드
    public double getPrice() {
        return price;
    }

    // 가격을 설정하는 메서드
    public void setPrice(double price) {
        this.price = price;
    }

    // 책 정보를 문자열로 반환하는 메서드 (출력용)
    @Override
    public String toString() {
        // 책 제목, 저자, ISBN, 가격을 탭을 구분자로 출력
        return " " + title + " \t " + author + " \t " + ISBN + " \t " + price;
    }
}
