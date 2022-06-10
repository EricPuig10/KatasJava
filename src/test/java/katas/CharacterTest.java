package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    public void charactersShouldHave1000hpAtStart() {
        Character sonGoku = new Character();

        int result = sonGoku.getHealth();

        assertEquals(1000, result);

    }

    @Test
    public void charactersShouldStartWithLvl1() {
        Character sonGoku = new Character();

        int result = sonGoku.getLvl();

        assertEquals(1, result);
    }

    @Test
    public void charactersShouldStartBeingAlive() {
        Character sonGoku = new Character();

        boolean result = sonGoku.getIsAlive();

        assertTrue(result);
    }

    @Test
    public void characterAttacksAnotherCharacterAndSubstractsFromHealth(){
        var attacker = new Character();
        var victim = new Character();

        victim.getHealth();
        attacker.attacksOther(victim, 50);
        int result = victim.getHealth();

        assertEquals(950,result);
    }

    /*
    @Test
    public void charactersCanDealDamageFromCharacters() {

        Character sonGoku = new Character(1000,1,true, "melee",2);
        Character luffy = new Character(1000,1,true, "ranged",20);

        luffy.dealDamageFromAttacker(10, sonGoku);
        int result = luffy.getHealth();

        assertEquals(990, result);

    } */

    @Test
    public void charactersDiesIfDamageIsBiggerThanHealth(){
        Character sonGoku = new Character(1000,1,true,1);
        Character victim = new Character(1000,1,true, 1);

        sonGoku.attacksOther(victim, 1200);
        boolean result = victim.getIsAlive();

        assertFalse(result);

    }

    /*
    @Test
    public void charactersCanHeal() {

        Character sonGoku = new Character(1000,1,true, "melee",2);

        Character luffy = new Character(1000,1,true, "ranged",20);


        luffy.dealDamageFromAttacker(100, sonGoku);
        luffy.healCharacter(5, luffy);
        int result = luffy.getHealth();

        assertEquals(905, result);

    }*/

    @Test
    public void charactersCanHealRefactored(){
        Character healer = new Character(1000,1,true,1);

        Character luffy = new Character(1000,1,true,1);


        luffy.attacksOther(healer, 100);
        healer.healItself(5,healer);
        int result = healer.getHealth();

        assertEquals(905, result);
    }

    @Test
    public void charactersCantHealthOver1000(){
        Character sonGoku = new Character(1000,1,true,1);
        Character luffy = new Character(1000,1,true,1);


        sonGoku.attacksOther(luffy, 100);
        luffy.healItself(200, luffy);
        int result = luffy.getHealth();

        assertEquals(1000, result);

    }

    @Test
    public void charactersCantDamageItSelfs(){

        Character sonGoku = new Character(1000,1,true,1);

        sonGoku.attacksOther(sonGoku, 100);
        int result = sonGoku.getHealth();

        assertEquals(1000, result);

    }

    @Test
    public void charactersOnlyCanHealItSelf(){

        Character sonGoku = new Character(1000,1,true,1);
        Character victim = new Character(1000,1,true,1);

        sonGoku.attacksOther(victim, 100);
        System.out.println(victim.getHealth());
        victim.healItself(1, victim);
        int result = victim.getHealth();

        assertEquals(901, result);

    }

    /*
    @Test
    public void onDealingDamageIfTargetIs5orMoreLvlsAboveTheAttackerDamageIsReducedBy50PercentAndReverse(){
        Character sonGoku = new Character(1000,2,true, "melee",2);
        Character luffy = new Character(1000,8,true,"ranged", 20);

        //luffy.setLvl(8);
        //sonGoku.setLvl(2);
        sonGoku.dealDamageFromAttacker(100, luffy);

        int result = sonGoku.getHealth();

        assertEquals(800, result);
    }*/

    @Test
    public void onAttackIfTargetIs5LevelsOrMoreDamageIsReducedToHalfAndReverse(){
        Character sonGoku = new Character(1000,2,true,1);
        Character Luffy = new Character(1000,8,true,1);


        sonGoku.attacksOther(Luffy, 100);

        int result = Luffy.getHealth();

        assertEquals(950, result);
    }

    @Test
    public void charactersShouldHaveMaxRange(){
        Character luffy = new Character();

        int result = luffy.getMaxRange();

        assertEquals(luffy.getMaxRange(),result);
    }

    @Test
    public void meleeCharactersHaveARangeOf2MetersAndRangedCharactersHaveARangeOf20meters(){
        Character Luffy = new Character(1000,1,true,1);
        Character Goku = new Character(1000,1,true,1);


        Luffy.setTypeOfCharacterMelee();
        Goku.setTypeOfCharacterRanged();

        int result = Luffy.getMaxRange();

        assertEquals(2, result);
    }

    @Test
    public void charactersMustBeInRangeToAttackTarget(){
        Character Luffy = new Character(1000,2,true, 10);
        Character Goku = new Character(1000,8,true,1);

        Luffy.setTypeOfCharacterMelee();
        Goku.setTypeOfCharacterRanged();


        Goku.attacksOther(Luffy,100);


        int result = Luffy.getHealth();

        assertEquals(800, result);


    }


}