package a0324.rpg2;

public class cartest {
    public static void main(String[] args) {
        truck t = new truck("봉고", 1.5);
        t.move();  // 차 이동
        t.load();  // 트럭 물건 적재
    }
}

class car {
    String name;

    public car(String _name) {
        name = _name;
        System.out.printf("모델명: %s\n", name);

    }

    void move() {
        System.out.printf("[%s]가 이동합니다.\n", name);
    }
}

class truck extends car {
    double payload; // 트럭 최대 적재량

    public truck(String _name, double _payload) {
        super(_name);
        payload = _payload;
    }

    void load() {
        System.out.printf("[%s]가 물건을 적재합니다.(최대 %.1f 톤)\n", name, payload);

    }
}
