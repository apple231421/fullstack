package a0324.game1;

public class raichu extends pikachu {

    public raichu(int energy, String type, int level) {
        super(energy, type, level);
    }

    public raichu(int energy, String type) {
        super(energy, type);
    }

    @Override
    public String attack() {
        return "백만볼트";
    }

    @Override
    public String battack() {
        return "볼트체인지";
    }

    public String cattack() {
        if (level > 40) {
            return "아이언테일";
        } else {
            return "사용불가";
        }
    }
}
