public class Role {
    private String name;
    private int health;
    private  int attackPower;

    public Role(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public void attack(Role opponent) {
        opponent.health -= this.attackPower;
        System.out.println(this.name + " attacks " + opponent.name + " for " + this.attackPower + " damage.");
    }
}
