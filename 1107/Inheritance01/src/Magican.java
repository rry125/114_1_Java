public class Magican extends  Role {

    private final int healPower;

    public Magican(String name, int health, int magicPower, int healPower) {
        super(name, health, magicPower);
        this.healPower = healPower;
    }

    public int getHealPower() {
        return healPower;
    }

    public void attack(Magican opponent) {
        opponent.setHealth(opponent.getHealth() - this.getAttackPower());
        System.out.println(this.getName() + " casts a spell on " + opponent.getName() + " for " + this.getAttackPower() + " damage.");
    }


    private void heal(SwordsMan ally){
        ally.setHealth(ally.getHealth() + this.healPower);
        System.out.println(this.getName() + " heals " + ally.getName() + " for " + this.healPower + " health.");
    }

}
