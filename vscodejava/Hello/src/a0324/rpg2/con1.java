package a0324.rpg2;

public class con1 {
    public static void main(String[] args) {
        new bbb();
    }
}

class aaa {
    aaa() {
        System.out.println("aaa() 생성자 호출 완료");
    }
}

class bbb extends aaa {
    bbb() {
        System.out.println("bbb() 생성자 호출 완료");
    }
}
// 상속 관계에서 자식 객체가 만들어지려면 부모영역이 먼저 완성
// 건물이 1층이 완성되어야 2층이 올릴수 있는것과 같은 의미
// 자식생성자는 부모생성자를 반드시  호출 되어야하는데
// 이를 생략한 경우 부모생성자 호출코드 super()자동 삽입