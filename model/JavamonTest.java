package model;

import org.junit.*;
import static org.junit.Assert.*;

public class JavamonTest {

    @Test
    public void testJavamon() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        assertEquals("Incorrect owner name instantiation", s.getJavamonName(), "Squirtle");
        assertEquals("Incorrect max health instantiation", s.getMaxHealth(), 1000);
        assertEquals("Incorrect attack instantiation", s.getBaseAttack(), 80);
        assertEquals("Incorrect defense isntantiation", s.getBaseDefense(), 64);
        assertEquals("Incorrect speed instantiation", s.getSpeed(), 43);
        assertEquals("Incorrect attack modifier instantiation", s.getAttackStage(), 0);
        assertEquals("Incorrect defense modifier instantiation", s.getDefenseStage(), 0);
    }

    @Test
    public void testHealthBelowZero() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        s.changeHealth(-5);
        assertEquals("Health not changed correctly", 1000 - 5, s.getCurrentHealth());
        s.changeHealth(-3000);
        assertTrue("Health is below zero", s.getCurrentHealth() >= 0);
    }

    @Test
    public void testHealthAboveMax() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        s.changeHealth(5);
        assertEquals("Health should not go above max health", s.getMaxHealth(), s.getCurrentHealth());
    }

    @Test
    public void testParalysis() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        s.changeParalyzeTurns(5);
        assertTrue("Should be paralyzed", s.isParalyzed());
        s.changeParalyzeTurns(-8);
        assertTrue("Paralysis should not go below 0", s.getParalyzeTurns() == 0);
    }

    @Test
    public void testChangeModifier() {
        Javamon s = JavamonFactory.makeSquirtle(true);
        s.changeAttackModifier(1);
        assertEquals("Attack modifier incorrectly changed values", s.getAttackStage(), 1);
        s.changeDefenseModifier(1);
        assertEquals("Defense modifier incorrectly changed values", s.getDefenseStage(), 1);
        s.changeAttackModifier(-1);
        assertEquals("Attack modifier incorrectly changed values", s.getAttackStage(), 0);
        s.changeDefenseModifier(-1);
        assertEquals("Defense modifier incorrectly changed values", s.getDefenseStage(), 0);

    }


}
