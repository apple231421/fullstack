package a0321.account;

public class student {
    private String name;
    private int studentid;
    private int kor, math, eng;

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public String getName() {
        return name;
    }

    public int getStudentid() {
        return studentid;
    }

    public int getKor() {
        return kor;
    }

    public int getMath() {
        return math;
    }

    public int getEng() {
        return eng;
    }

    public student(String name, int studentid, int kor, int math, int eng) {
        this.name = name;
        this.studentid = studentid;
        this.kor = kor;
        this.math = math;
        this.eng = eng;
    }

    public double getaverage() {
        double result = (kor + math + eng) / 3.0;
        return result;
    }

    public int getsum() {
        int result = kor + math + eng;
        return result;
    }

    public student() {

    }
}
