package a0324.doseo;

public class printbook extends book {
    private int pagecount; // 페이지수
    private int weight; // 책무게

    public printbook(String title, String author, String isbn, int pagecount, double weight) {
        super(title, author, isbn);
        this.pagecount = pagecount;
        this.weight = (int) weight;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void displayinfo() {
        super.displayinfo();
        System.out.println("pagecount " + pagecount);
        System.out.println("weight" + weight + " kg");
    }
}
