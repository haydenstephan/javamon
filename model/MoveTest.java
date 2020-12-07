package model;

import org.junit.*;
import static org.junit.Assert.*;

public class MoveTest {
    @Test
    public void testMoveWithoutEffect() {
        Move move = new Move("demo", 3, 5);
        assertEquals("Incorrect name isntantiation", "demo", move.getName());
        assertEquals("Incorrect accuracy isntantiation", 5, move.getAccuracy());
        assertEquals("Incorrect power isntantiation", 3, move.getPower());
    }

    @Test
    public void testMoveWithEffect() {
        Move move = new Move("demo", 3, 5, Effect.decreaseAttack);
        assertEquals("Incorrect name isntantiation", "demo", move.getName());
        assertEquals("Incorrect accurcy isntantiation", 5, move.getAccuracy());
        assertEquals("Incorrect power isntantiation", 3, move.getPower());
        assertEquals("Incorrect effect isntantiation", Effect.decreaseAttack, move.getEffect());
        assertTrue("move should have effect", move.hasEffect());
    }

}
