public class Knight extends Creature implements Soundable {

    public Knight(String name, int health, int power, int skill, int xp, int gold) {
        super(name, health, power, skill, xp, gold);
    }

    @Override
    public String sound() {
        return "Huyak!";
    }
}
