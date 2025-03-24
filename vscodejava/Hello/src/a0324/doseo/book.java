package a0324.doseo;

public class book {
    private String title;
    private String author;
    private String isbn;

    public book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // 도서정보 출력 메서드
    public void displayinfo() {
        System.out.println("title " + title);
        System.out.println("author " + author);
        System.out.println("isbn " + isbn);
    }
}