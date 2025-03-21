package a0321;

public class herotest {
    public static void main(String[] args) {
        hero thor = new hero("토르", 150);
        hero thannos = new hero("타노스", 160);
        thor.punch(thannos);
        thor.punch(thannos);
        thannos.punch(thor);
    }
}

class hero {
    String name; // 이름
    int hp; // 체력

    hero(String n, int h) {
        name = n;
        hp = h;
    }

    void punch(hero enemy){
        System.out.printf("[%s]의 펀치!",name);
        enemy.hp -= 10;
        System.out.printf("-> %s의 체력 : %d\n",enemy.name,enemy.hp);
    }
}