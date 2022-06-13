package katas;

import katas.rpgCombat.Character;
import katas.rpgCombat.Faction;
import katas.rpgCombat.House;
import katas.rpgCombat.Prop;
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
        Character Goku = new Character(1000,1,true,1);

        Character luffy = new Character(1000,1,true,1);


        luffy.attacksOther(Goku, 100);
        Goku.healsItselfOrAllies(5,Goku);
        int result = Goku.getHealth();

        assertEquals(905, result);
    }

    @Test
    public void charactersCantHealthOver1000(){
        Character sonGoku = new Character(1000,1,true,1);
        Character luffy = new Character(1000,1,true,1);


        sonGoku.attacksOther(luffy, 100);
        luffy.healsItselfOrAllies(200, luffy);
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
        victim.healsItselfOrAllies(1, victim);
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
    @Test
    public void charactersMustBelongToOneOrMoreFactionsButWhenCreatedBelongToNoFaction(){
            Character Goku = new Character();


            Faction fire = new Faction("fire");
            fire.join(Goku);

            assertTrue(Goku.isMemberOf(fire));
        }


    @Test
    public void charactersCanLeaveFactions(){
        Character Goku = new Character();
        Faction fire = new Faction("fire");

        fire.join(Goku);
        fire.leave(Goku);

        var result = Goku.isMemberOf(fire);

        assertEquals(false , result);
    }

    @Test
    public void testGokuAndVegetaAreAllys(){
        Character Goku = new Character();
        Character Vegeta = new Character();

        Faction fireFaction = new Faction("fire");
        fireFaction.join(Goku);
        fireFaction.join(Vegeta);
        assertTrue(Goku.isAlly(Vegeta));
    }

    @Test
    public void alliesCantHurtOtherAllies(){
        Character Goku = new Character();
        Character Vegeta = new Character();

        Faction fireFaction = new Faction("fire");
        fireFaction.join(Goku);
        fireFaction.join(Vegeta);

        Goku.attacksOther(Vegeta, 100);

        var result = Vegeta.getHealth();

        assertEquals(1000, result);

    }

    @Test
    public void alliesCanHealOtherAllies(){
        Character Goku = new Character();
        Character Vegeta = new Character();
        Character Freezer = new Character();

        Faction fireFaction = new Faction("fire");
        fireFaction.join(Goku);
        fireFaction.join(Vegeta);

        Freezer.attacksOther(Vegeta,100);
        Goku.healsItselfOrAllies(50, Vegeta);

        var result = Vegeta.getHealth();

        assertEquals(950, result);

    }

    @Test
    public void charactersCanAttackObj(){
        Character Goku = new Character();
        Prop house = new House(2000);
        house.isAttackedBy(Goku,100);

        var result = house.getHealth();
        assertEquals(1900, result);
    }
    @Test
    public void whenHealthEquals0ObjGetsDestroyed(){
        Character Goku = new Character();
        Prop house = new House(2000);
        house.isAttackedBy(Goku,3000);

        var result = house.isAlive();
        assertEquals(false, result);
    }






    @Test
    public void objCantBeHealed(){
        //function heal cant be used in a prop
    }

    @Test
    public void objDontBelongToFactions(){
        //factions requires a Character, cant be a Prop
    }









}