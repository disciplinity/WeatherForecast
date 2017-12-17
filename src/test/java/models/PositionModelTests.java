package models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Created by Daiy on 17.12.2017.
 */
public class PositionModelTests {

    private Position pos1 = new Position(234, 432);
    private Position pos2  = new Position(456.0, 654.0);
    private Position pos3 = new Position(432, 234);

    @Test
    public void testPositionsForEquality() {
        assertEquals(pos1, pos2);
    }


    @Test
    public void testPositionsForNonEquality() {
        assertNotEquals(pos1, pos3);
    }
}
