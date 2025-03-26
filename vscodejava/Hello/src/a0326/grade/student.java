package a0326.grade;

public class student {
    private int id;
    private String name;
    private int score;

    

    public student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // 학생의 정보 출력
    public void display() {
        System.out.println("id : " + id + " 이름 : " + name + " ,점수 : " + score);
    }

    @Override
    public String toString() {
        return "student [id=" + id + ", name=" + name + ", score=" + score + "]";
    }

}
