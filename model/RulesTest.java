package model;

import org.junit.*;
import static org.junit.Assert.*;

public class RulesTest {

    @Test
    public void testDamageDoneByMove1() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        int damage = Rules.calculateDamageDone(s.getMove1(), s, b);
        assertEquals("incorrect damage calculated", 145, damage);
    }

    @Test
    public void testDamageDoneByMove2() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        int damage = Rules.calculateDamageDone(s.getMove2(), s, b);
        assertEquals("incorrect damage calculated", 185, damage);
    }

    @Test
    public void testDamageDoneByMove3() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        int damage = Rules.calculateDamageDone(s.getMove3(), s, b);
        assertEquals("incorrect damage calculated", 0, damage);
    }

    @Test
    public void testDamageDoneByEmpowered() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        s.setIsEmpowered(true);
        int damage = Rules.calculateDamageDone(s.getMove1(), s, b);
        assertEquals("incorrect damage calculated", 348, damage);
    }

    @Test
    public void testDamageDoneByChangedStats() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);

        Move move = new Move("demo", 100, 100);

        s.changeAttackModifier(1);
        b.changeDefenseModifier(-2);

        int damage = Rules.calculateDamageDone(move, s, b);
        int expectedDamage = Rules.getModifiedAttack(s) - Rules.getModifiedDefense(b) + move.getPower();
        assertEquals("incorrect damage calculated", expectedDamage, damage);
    }


    @Test
    public void testIsJavamonFaster() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        assertFalse("Javamon speed not calculated corrctly", Rules.isJavamonFaster(s, b));
    }

    @Test
    public void testApplyEffectWNoEffect() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        int sOriginalDefense = s.getDefenseStage();
        int bOriginalDefense = b.getDefenseStage();
        Rules.applyEffect(s.getMove1(), s, b);
        assertEquals("Defense should not change", sOriginalDefense, s.getDefenseStage());
        assertEquals("Defense should not change", bOriginalDefense, b.getDefenseStage());
    }

    @Test
    public void testApplyEffectWithDecreaseAttack() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);

        Move move = new Move("demo", 0, 100, Effect.decreaseAttack);

        int sOriginalAttack = s.getAttackStage();
        int bOriginalAttack = b.getAttackStage();
        Rules.applyEffect(move, b, s);
        assertEquals("DecAtk should decrease targets attck", sOriginalAttack - 1, s.getAttackStage());
        assertEquals("DecAtk should not change attackers attack", bOriginalAttack, b.getAttackStage());
        s.changeAttackModifier(-5);
        Rules.applyEffect(move, b, s);
        assertEquals("Defense of target should not go below -6", bOriginalAttack - 6, s.getAttackStage());

    }

    @Test
    public void testApplyEffectWithDecreaseDefense() {
        Javamon p = JavamonFactory.makePikachu(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);

        Move move = new Move("demo", 0, 100, Effect.decreaseDefense);

        int pOriginalDefense = p.getDefenseStage();
        int bOriginalDefense = b.getDefenseStage();

        Rules.applyEffect(move, p, b);

        assertEquals("DecDef should decrease targets defense", bOriginalDefense - 1, b.getDefenseStage());
       
        assertEquals("DecDef should not change attackers defense", pOriginalDefense, p.getDefenseStage());
       
        p.changeDefenseModifier(-5);
        Rules.applyEffect(move, b, p);

        assertEquals("Defense of target should not go below -6", pOriginalDefense - 6, p.getDefenseStage());

    }

    @Test
    public void testApplyEffectIncreaseAttack() {
        Move move = new Move("demo", 0, 100, Effect.increaseAttack);

        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        int sOriginalAttack = s.getAttackStage();
        int bOriginalAttack = b.getAttackStage();
        Rules.applyEffect(move, b, s);
        assertEquals("DecAtk should increase attackers attck", bOriginalAttack + 1, b.getAttackStage());
        assertEquals("DecAtk should not change target's attack", sOriginalAttack, s.getAttackStage());
        b.changeAttackModifier(4);
        Rules.applyEffect(move, b, s);
        assertEquals("Defense of target should not go above 6", bOriginalAttack + 6, b.getAttackStage());
    }

    @Test
    public void testApplyEffectIncreaseDefense() {
        Move move = new Move("demo", 0, 100, Effect.increaseDefense);

        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        int sOriginalDefense = s.getDefenseStage();
        int bOriginalDefense = b.getDefenseStage();
        Rules.applyEffect(move, s, b);
        assertEquals("DecDef should increase attackers defense", sOriginalDefense + 1, s.getDefenseStage());
        assertEquals("DecDef should not change targets defense", bOriginalDefense, b.getDefenseStage());
        s.changeDefenseModifier(5);
        Rules.applyEffect(move, s, b);
        assertEquals("Defense of attacker should not go above 6", sOriginalDefense + 6, s.getDefenseStage());
    }


    @Test
    public void testApplyEffectParalysis() {
        Move move = new Move("demo", 0, 100, Effect.paralyze);

        Javamon s = JavamonFactory.makeSquirtle(true);
        Javamon b = JavamonFactory.makeBulbasaur(false);
        Rules.applyEffect(move, b, s);
        assertEquals("there should be two turns of paralysis", 2, s.getParalyzeTurns());
        Rules.applyEffect(move, b, s);
        assertEquals("there should be three turns of paralysis", 3, s.getParalyzeTurns());
    }


    @Test
    public void testDidMovePassZeroMoveAccuracy() {
        Move m = new Move("Zero accuracy", 0, 0);
        Javamon j = JavamonFactory.makeSquirtle(true);
        assertFalse("Accuracy not correctly working", Rules.didMovePass(j, m));
    }

    @Test
    public void testDidMovePassZeroJavamonAccuracy() {
        Move m = new Move("100 accuracy", 10, 100);
        Javamon j = JavamonFactory.makeSquirtle(true);
        j.changeAccuracy(-j.getAccuracy());
        assertFalse("Accuracy not correctly working", Rules.didMovePass(j, m));
    }

    @Test
    public void testDidMovePassPerfectAccuracy() {
        Move m = new Move("100 accuracy", 10, 100);
        Javamon j = JavamonFactory.makeSquirtle(true);
        assertTrue("Accuracy not correctly working", Rules.didMovePass(j, m));
    }
}
