package katas.rpgCombat;

public class House implements Prop {

    public House(int health){
        this.health=health;
    }

    public int health;
    public boolean isAlive = true;
    public int maxHealth = 1000;




    @Override
    public void isAttackedBy(Character attacker, int damage) {
        if (this.health <= damage || this.health < 0) {
            this.health = 0;
            this.isAlive = false;
            return;
        }
        health -= damage;
    }

    @Override
    public void attacksOther(Character victim, int damage) {

    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }


}
