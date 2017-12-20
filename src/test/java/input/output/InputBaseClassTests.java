package input.output;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertArrayEquals;


public class InputBaseClassTests {

    private final String[] CITIES_1 = {"San Jose", "Madrid", "Saint Petersburg"};
    private final String[] CITIES_2 = {"Paris"};
    private final String[] CITIES_3 = {};

    @Test
    public void testMultipleCities() {
        checkEquality(CITIES_1, "src/test/java/input/output/Cities1.txt");
    }

    @Test
    public void testFileOneCity() {
        checkEquality(CITIES_2, "src/test/java/input/output/Cities2.txt");
    }

    @Test
    public void testFileNoCities() {
        checkEquality(CITIES_3, "src/test/java/input/output/Cities3.txt");
    }

    private void checkEquality(String[] awaitedCitiesArray, String fileName) {
        File file = new File(fileName);

        try {
            InputFromFile inputFromFile = new InputFromFile(file);
            String[] receivedCitiesArray = inputFromFile.readNextCityLine();
            assertArrayEquals(awaitedCitiesArray, receivedCitiesArray);
        } catch (Exception e) {
            fail();
        }
    }
}
