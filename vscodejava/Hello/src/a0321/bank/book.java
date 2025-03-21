package a0321.bank;

public class book {
    private String title; // 책추가
    private String author; // 저자
    private int status; // 대출가능여부

    public book(String title, String author, int status) {
        this.title = title;
        this.author = author;
        this.status = status;
    }

    // 책 제목
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    // 책 저자
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // 책 반납 상태
        public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
