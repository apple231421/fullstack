package a0324.book1;

public class library {

    private String title; // 책제목
    private String author; // 책저자
    private String location; // 책위치
    private String isbn; // 출판년도
    private boolean available; // 대여 가능여부

    public library() { // 기본생성자
    }

    public library(String title, String author, String location, String isbn) {
        this.title = title;
        this.author = author;
        this.location = location;
        this.isbn = isbn;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "책 제목 : " + title + ", 저자 : " + author + ", 책 위치 : " + location + ", 출판년도 : " + isbn
                + ", 대여 여부 : " + (available ? "대출가능" : "대출 중");
    }

    // 도서대출후 대출불가능 메서드 작성
    public void book() {
        this.available = false;
    }
}
