package input.output;


import java.util.Scanner;

public abstract class InputBaseClass {

    private  Scanner inputBuffer;
    private final String comma = ",";

    public String[] readNextCityLine() {
        String line;
        String[] cities = {};
        if (inputBuffer.hasNextLine()) {
            line = inputBuffer.nextLine();
            cities = separateLine(line);

        }
        return cities;
    }

    private String[] separateLine(String line) {

        String[] cityNames = line.split(comma);
        for (int ch = 0; ch < cityNames.length; ch++) {
            cityNames[ch] = cityNames[ch];
        }
        return cityNames;

    }


    public void setInputBuffer(Scanner inputBuffer) {
        this.inputBuffer = inputBuffer;
    }
}
