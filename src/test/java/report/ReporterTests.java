package report;

import exceptions.WeatherEntitiesDoNotExistException;
import org.junit.Before;
import org.junit.Test;
import weather.CurrentWeatherEntity;
import weather.WeatherForecastEntity;

import static org.mockito.Mockito.mock;



public class ReporterTests {


    @Test(expected = WeatherEntitiesDoNotExistException.class)
    public void testWeatherEntitiesDoNotExistAndMustThrowException() {
        ReportMaker reporter = new OpenWeatherReporter();
        reporter.generateReport();
    }


    @Test(expected = NullPointerException.class) // Expecting nullpointer because mocked entities get passed to jsoncreator
    public void testWeatherEntitiesExist() {
        ReportMaker reporter = new OpenWeatherReporter(mock(CurrentWeatherEntity.class), mock(WeatherForecastEntity.class));
        reporter.generateReport();
    }
}
