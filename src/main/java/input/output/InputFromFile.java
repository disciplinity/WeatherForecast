package input.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class InputFromFile extends InputBaseClass {

    public InputFromFile(File file) throws FileNotFoundException {
        setInputBuffer(new Scanner(file));
    }
}
