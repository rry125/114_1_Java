public class ShieldSwordsMan extends SwordsMan{
    private int defenseCapacity;
    // 建構子：初始化持盾劍士的名稱、生命值和攻擊力
    public ShieldSwordsMan(String name, int health, int attackPower, int defenseCapacity) {
        super(name, health, attackPower);
        this.defenseCapacity = defenseCapacity;
    }

    // 攻擊對手(劍客/魔法師)，父類別的參考指到子類別物件
    @Override
    public void attack(Role opponent) {
        int reducedDamage = this.getAttackPower() - 5; // 持盾劍士攻擊力減少5點
        System.out.println("⚔️  " + this.getName() + " 揮劍攻擊 " + opponent.getName() + "！");
        opponent.takeDamage(reducedDamage);
    }

    public int getDefenseCapacity() {
        return defenseCapacity;
    }

    public void defence() {
        this.setHealth(this.getHealth() + defenseCapacity);
        System.out.println(this.getName() + " 使用盾牌防禦，恢復 " + defenseCapacity + " 點生命值。" + this);
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + name + "的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：盾牌猛擊          ║");
        System.out.println("║ 技能描述：使用盾牌撞擊敵人  ║");
        System.out.println("║ 技能效果：造成傷害並暈眩       ║");
        System.out.println("║ 防禦加成：+8 防禦力      ║");
        System.out.println("╚═════════════════════════════╝");
    }

    // 戰鬥前的準備動作
    @Override
    public void prepareBattle() {
        System.out.println("🛡️  " + name + " 高舉盾牌，警戒四周，準備防守...");
    }

    // 戰鬥後的行為
    @Override
    public void afterBattle() {
        System.out.println(name + " 放下盾牌，整理裝備。\n");
    }

    // 死亡時的處理
    @Override
    public void onDeath() {
        System.out.println("💀 " + name + " 被擊倒，盾牌碎裂在地...");
        System.out.println(name + " 慢慢倒下，戰鬥結束。\n");
    }

}
