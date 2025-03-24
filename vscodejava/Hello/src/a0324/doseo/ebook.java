package a0324.doseo;

public class ebook extends book {
    private double filesize; // 파일크기(ex MB)
    private String format; // 파일포맷(ex pdf, epub)

    public ebook(String title, String author, String isbn, double filesize, String format) {
        super(title, author, isbn);
        this.filesize = filesize;
        this.format = format;
    }

    public double getFilesize() {
        return filesize;
    }

    public void setFilesize(double filesize) {
        this.filesize = filesize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void displayinfo() {
        super.displayinfo();
        System.out.println("file size " + filesize + "MB");
        System.out.println("format " + format);
    }
}