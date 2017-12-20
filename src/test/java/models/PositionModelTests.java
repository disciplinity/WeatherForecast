package models;

import locations.Position;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class PositionModelTests {

    private Position location = new Position(576, 489);
    private Position location2 = new Position(576.0, 489.0);
    private Position location3 = new Position(543, 345);

    @Test
    public void testPositionsAreEqual() {
        assertEquals(location, location2);
    }


    @Test
    public void testNotEquals() {
        assertNotEquals(location, location3);
    }
}
