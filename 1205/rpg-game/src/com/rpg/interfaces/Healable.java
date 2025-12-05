package  com.rpg.interfaces;

import com.rpg.core.Role;


public interface Healable {
    void heal(Role target);           // 抽象方法
    int getHealPower();               // 抽象方法
    default boolean canHeal() {       // 預設方法
        return getHealPower() > 0;
    }
    default void showHealInfo() {     // 預設方法
        System.out.println("💚 治療力：" + getHealPower());
    }
}
