package input.output;

import report.ReportMaker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class OutputFile {

    private File file;

    public OutputFile(File file) throws IOException {
        setFile(file);
    }

    public void setFile(File file) throws IOException {
        if (file == null) {
            throw new IOException("No such file exists.");
        } else {
            this.file = file;
        }
    }

    public void makeReport(ReportMaker reportMaker) throws IllegalArgumentException {
        try (FileWriter outputBuffer = new FileWriter(file)) {
            String report = reportMaker.makeReport();
            outputBuffer.append(report);
        } catch (IOException e ) {
            e.getStackTrace();
        }
    }
}
