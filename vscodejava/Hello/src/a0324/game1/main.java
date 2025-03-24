package a0324.game1;

public class main {
    public static void main(String[] args) {

        pikachu pikachu = new pikachu();
        System.out.println("######## 피카츄#######");
        System.out.println("에너지 : " + pikachu.energy);
        System.out.println("타입 : " + pikachu.type);
        System.out.println("레벨 : " + pikachu.level);
        System.out.println("공격 A : " + pikachu.attack());
        System.out.println("공격 B : " + pikachu.battack());

        pikachu pikachu20 = new pikachu(150, "전기,강철", 20);

        System.out.println("######## 피카츄20#######");
        System.out.println("에너지 : " + pikachu20.energy);
        System.out.println("타입 : " + pikachu20.type);
        System.out.println("레벨 : " + pikachu20.level);
        System.out.println("공격 A : " + pikachu20.attack());
        System.out.println("공격 B : " + pikachu20.battack());
        System.out.println();
    }
}
    