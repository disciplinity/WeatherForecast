package input.output;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class InputFromFileTests {

    @Test(expected = FileNotFoundException.class)
    public void testWrongFileName() throws IOException {
        File file = new File("i want to sleep");
        new InputFromFile(file);
    }

}
