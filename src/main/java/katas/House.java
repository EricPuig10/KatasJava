package katas;

public class House implements Prop{

    House(int health){
        this.health=health;
    }

    private int health;
    private boolean isAlive = true;
    private int maxHealth = 1000;




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
