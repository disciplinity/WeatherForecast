package input.output;

import java.util.Scanner;


public class InputFromConsole extends InputBaseClass {

    public InputFromConsole() {
        setInputBuffer(new Scanner(System.in));
    }
}
