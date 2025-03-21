package a0321.account;

public class webtoontest {
    public static void main(String[] args) {
        webtoon levelupup = new webtoon("나 혼자만 레벨업업", "판타지", "추공님");
        webtoon sweethouse = new webtoon("스위트 집", "스릴러", "칸비님");
        webtoon itaewonclassic = new webtoon("이태원 클래식", "드라마", "광진님");

        // 웹툰 객체 배열 생성
        webtoon[] webtoons = { levelupup, sweethouse, itaewonclassic };

        // 웹툰 정보 출력
        for (int i = 0; i < webtoons.length; i++) {
            System.out.println(webtoons[i]); // toString()이 자동 호출됨
        }

        // 총 웹툰 개수 출력
        System.out.printf("웹툰 객체의 총 수 : %d", webtoon.getcount());
    }
}

class webtoon {
    private String title;
    private String genre;
    private String author;
    private static int count = 0; // 웹툰 객체 개수를 저장하는 정적 변수

    public webtoon(String t, String g, String a) {
        this.title = t;
        this.genre = g;
        this.author = a;
        count++; // 객체 생성 시 증가
    }

    public static int getcount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("webtoon{title: %s, genre: %s, author: %s}", title, genre, author);
    }
}
