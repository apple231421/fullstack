package a0324.rpg2;

public class overridingtest {
    public static void main(String[] args) {
        archer a = new archer();
        masterarcher m = new masterarcher();
        a.shoot();
        m.shoot();
    }
}

class archer {
    void shoot() {
        System.out.println("[아처]의 활 공격이 10만큼 피해를 주었다.");
    }
}

class masterarcher extends archer {
    void shoot() {
        System.out.println("[마스터아처]의 활 공격이 30만큼 피해를 주었다.");
    }
}
// 레퍼런스(참조) 변수 m은 연결 객체를 archer라고 해석하지만, 실제로 연결된 객체는 masterarcher이다.
// 메서드 오버라이딩 이 된다. 그 결과로 archer 클래스의 shoot메소드가 아닌, 재정의 된
// masterarcher 클래스의 shoot() 메소드가 수행
