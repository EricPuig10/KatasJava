package katas.rpgCombat;

import java.util.ArrayList;
import java.util.List;

public class Character {

    public Character(int health, int lvl, boolean isAlive, int position) {
        this.health = health;
        this.lvl = lvl;
        this.isAlive = isAlive;
        this.position = position;

    }

    public Character() {

    }

    private int health = 1000;
    private int lvl = 1;
    private boolean isAlive = true; //is alive or not

    private int position;

    public void setPosition(int num) {
        this.position = num;
    }

    private int maxPosition = 100;
    private String typeOfCharacter;

    public void setTypeOfCharacterMelee() {
        this.maxRange = 2;
    }

    public void setTypeOfCharacterRanged() {
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

    private int differenceOf5Levels = 5;

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
        System.out.println(this.position);
        System.out.println(victim.position);
        System.out.println(this.maxRange);

        if (isAlly(victim)) return;

        if (this.position - victim.position > this.maxRange) return;

        if (victim.position - this.position > this.maxRange) return;

        if (this.lvl - victim.lvl >= differenceOf5Levels) {
            victim.damage(victim, damage * 2);
            return;
        }
        if (victim.lvl - this.lvl >= differenceOf5Levels) {
            victim.damage(victim, damage / 2);
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


    //No se com passar-ho a dins de la funcio perqu?? se sapiga qu?? ??s
    /*
    public void getDamageFactor(int damage, Character character){
        if (this.lvl - character.lvl >= 5) {
            this.health -= damage / 2;
        } else if (character.lvl - this.lvl >= 5){
            this.health -= damage * 2;
        } else this.health -= damage;
    }*/


    public void healsItselfOrAllies(int heal, Character character) {
        if(isAlly(character) || this==character )
        character.heal(heal, character);
    }

    private void heal(int heal, Character character) {
        if (!this.isAlive) {
            return;
        }
        if (this != character) {
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



    private List<Faction> factions = new ArrayList<Faction>();

    private boolean isAlly = false;


    public boolean isMemberOf(Faction faction) {
        for (int i = 0; i < factions.size(); i++) {
            if (this.factions.get(i).getFactionName() == faction.getFactionName())
                return true;
        }
        return false;
    }

    public void addFaction(Faction faction) {
        factions.add(faction);
    }

    public void removeFaction(Faction faction) {
        factions.remove(faction);
    }

    public boolean isAlly(Character character) {
        for (int i = 0; i < factions.size(); i++) {
            if (character.isMemberOf(factions.get(i))) {
                return true;
            }
        }
        return false;
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



