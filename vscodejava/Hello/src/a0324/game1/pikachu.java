package a0324.game1;

public class pikachu {
    public int energy;
    public String type;
    public static int level;

    public pikachu() {
        this(100, "전기", 1);
    }

    public pikachu(int energy, String type) {
        this(energy, type, level);

    }

    public pikachu(int energy, String type, int level) {
        this.energy = energy;
        this.type = type;
        this.level = level;
    }

    public String attack() {
        return "십만볼드";
    }

    public String battack() {
        return "전광속화";
    }
}
