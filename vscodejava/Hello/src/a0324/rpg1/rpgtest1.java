package a0324.rpg1;

public class rpgtest1 {
    public static void main(String[] args) {
        wizard wizard = new wizard();
        wizard.name = "간달프";
        wizard.hp = 100;
        wizard.mp = 80;
        wizard.speed = 2;
        wizard.move();
        wizard.punch();
        wizard.fireball();

        knight knight = new knight();
        knight.name = "아서";
        knight.hp = 150;
        knight.stamina = 70;
        knight.speed = 3;
        knight.move();
        knight.punch();
        knight.slash();
    }
}

class novice {
    String name;
    int hp;
    int speed;

    void punch() {
        System.out.printf("%s(HP : %d)의 펀치!\n", name, hp);
    }

    void move() {
        System.out.printf("%d 만큼 이동합니다.\n", speed);
    }
}

class wizard extends novice {
    int mp;

    void fireball() {
        System.out.printf("%s(HP : %d, MP : %d)의 파이어볼~~~~!\n", name, hp, mp);
        System.out.println();
    }
}


class knight extends novice {
    int stamina;

    void slash() {
        System.out.printf("%s(HP : %d, St : %d)의 슬래쉬~~~~!\n", name, hp, stamina);
    }
}