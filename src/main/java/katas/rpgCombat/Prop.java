package katas.rpgCombat;

import katas.rpgCombat.Character;

public interface Prop {


    void isAttackedBy(Character attacker, int damage);

    void attacksOther(Character victim, int damage);

    double getHealth();

    boolean isAlive = true;

    boolean isAlive();
}
