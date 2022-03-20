public abstract class Creature implements Fighter {

    private String name;
    private int health, power, skill, xp, gold;

    public Creature(String name, int health, int power, int skill, int xp, int gold) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.skill = skill;
        this.xp = xp;
        this.gold = gold;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getSkill() {return skill;}
    public void setSkill(int skill) {
        this.skill = skill;
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    @Override
    public int attack() {
        if (skill * 3 > getRandomValue()) return power;
        else if (skill > 2 * getRandomValue()) return power * 2;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("Здоровье %s %d ", name, health);
    }

}
