public class SwordsMan extends Role{

    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void attack(SwordsMan opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " slashes " + opponent.getName() + " for " + this.getAttackPower() + " damage.");
    }


}
