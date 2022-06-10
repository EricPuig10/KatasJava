package katas;

public class Character {

    public Character(int health, int lvl, boolean isAlive, String typeOfCharacter, int maxRange) {
        this.health = health;
        this.lvl = lvl;
        this.isAlive = isAlive;
        this.typeOfCharacter = typeOfCharacter;
        this.maxRange = maxRange;
    }

    public Character() {

    }

    private int health = 1000;
    private int lvl = 1;
    private boolean isAlive = true; //is alive or not

    //private Position position;
    private String typeOfCharacter;

    public void setTypeOfCharacterMelee(String melee) {
        this.typeOfCharacter = melee;
        this.maxRange = 2;
    }

    public void setTypeOfCharacterRanged(String ranged) {
        this.typeOfCharacter = ranged;
        this.maxRange = 20;
    }

    private int maxRange;

    public int getMaxRange() {
        return this.maxRange;
    }

    public int setMaxRange(int num) {
        return this.maxRange = num;
    }

    private int maxHealth = 1000;

    public int getHealth() {
        return this.health;
    }

    public int getLvl() {
        return this.lvl;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public void setLvl(int num) {
        this.lvl = num;
    }

    public void attacksOther(Character victim, int damage) {
        if (this == victim) return;

        if (this.lvl - victim.lvl >= 5) {
            victim.damage(victim, damage*2);
            return;
        }
        if (victim.lvl - this.lvl >= 5) {
            victim.damage(victim, damage/2);
            return;
        }


        victim.damage(victim, damage);
    }

    private void damage(Character victim, int damage) {
        if (this.health <= damage || this.health < 0) {
            this.health = 0;
            this.isAlive = false;
            return;
        }
        this.health -= damage;
    }

    /* Logica reversa
    public void dealDamageFromAttacker(int damage, Character character) {

        if (this == character) {
            return;
        }
        if (this.health <= damage || this.health <= 0) {
            this.health = 0;
            this.isAlive = false;
            return;
        }
        if (this.lvl - character.lvl >= 5) {
            this.health -= damage / 2;
            return;
        }
        if (character.lvl - this.lvl >= 5) {
            this.health -= damage * 2;
            return;
        }
        this.health -= damage;


    }*/


    //No se com passar-ho a dins de la funcio perquè se sapiga què és
    /*
    public void getDamageFactor(int damage, Character character){
        if (this.lvl - character.lvl >= 5) {
            this.health -= damage / 2;
        } else if (character.lvl - this.lvl >= 5){
            this.health -= damage * 2;
        } else this.health -= damage;
    }*/


    public void healItself(int heal, Character healer) {
        healer.heal(heal, healer);
    }

    private void heal(int heal, Character healer) {
        if (!this.isAlive) {
            return;
        }
        if (this != healer) {
            this.health = this.health;
            return;
        }
        health += heal;
        if (this.health > maxHealth) {
            this.health = this.maxHealth;
            return;
        }
        this.health = this.health;


    }

    /*
    public void healCharacter(int Heal, Character character) {

        if (!this.isAlive) {
            return;
        }
        if (this != character) {
            this.health = this.health;
            return;
        }
        health += Heal;
        if (health >= maxHealth) {
            this.health = this.maxHealth;
            return;
        }
        this.health = this.health;


    }*/
}



