package input.output;

import org.junit.Test;
import report.ReportMaker;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;



public class OutputFileTests {

    @Test
    public void testGenerateReport() throws IOException {

        ReportMaker mockedReporter = mock(ReportMaker.class);


        File file = new File("test");
        OutputFile outputFile = new OutputFile(file);

        outputFile.makeReport(mockedReporter);

        verify(mockedReporter).generateReport();
    }
}
