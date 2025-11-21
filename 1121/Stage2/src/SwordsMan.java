public  class SwordsMan extends Role{
    // 建構子：初始化劍士的名稱、生命值和攻擊力
    public SwordsMan(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    // 攻擊對手(劍客/魔法師)，使用 Role.takeDamage 以統一受傷處理
    @Override
    public void attack(Role opponent) {
        System.out.println("⚔️  " + this.getName() + " 揮劍攻擊 " + opponent.getName() + "！");
        opponent.takeDamage(this.getAttackPower());
    }

    @Override
    public void showSpecialSkill() {
        System.out.println("╔═════════════════════════════╗");
        System.out.println("║ " + name + "的特殊技能        ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 技能名稱：連續斬擊          ║");
        System.out.println("║ 技能描述：快速揮劍三次  ║");
        System.out.println("║ 技能效果：造成 150% 傷害       ║");
        System.out.println("╚═════════════════════════════╝");
    }

    // 戰鬥前的準備動作
    @Override
    public void prepareBattle() {
        System.out.println("🗡️  " + name + " 擦拭劍刃，劍身反射出凜冽的寒光...");
    }

    // 戰鬥後的行為
    @Override
    public void afterBattle() {
        System.out.println(name + " 將劍收入劍鞘。\n");
    }

    // 死亡時的處理
    @Override
    public void onDeath() {
        System.out.println("💀 " + name + " 的生命之火熄滅了...");
        System.out.println(name + " 化作一縷青煙，消失在戰場上。\n");
    }

}
