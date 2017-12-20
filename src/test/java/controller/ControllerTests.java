package controller;

import input.output.InputBaseClass;
import input.output.OutputFile;
import locations.PositionData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import report.ReportMaker;
import weather.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



public class ControllerTests {

    private InputBaseClass input;
    private OutputFile output;
    private WeatherFetcher weatherFetcher;
    private Controller controller;
    private PrintStream errStream;
    private ByteArrayOutputStream errStreamToChange;
    private WeatherEntity currentWeatherEntity;
    private WeatherEntity weatherForecastEntity;

    @Before
    public void initControllerFields() {
        weatherFetcher = mock(WeatherFetcher.class);
        input = mock(InputBaseClass.class);
        output = mock(OutputFile.class);

        currentWeatherEntity = new CurrentWeatherEntity(mock(PositionData.class), mock(Weather.class));
        weatherForecastEntity = new WeatherForecastEntity(mock(PositionData.class), new SingleDayMinAndMaxWeather[]{});

        when(input.readNextCityLine()).thenReturn(new String[]{"Tallinn"});

        controller = new Controller(weatherFetcher, input, output);

        errStream = System.err;
        errStreamToChange = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errStreamToChange));
    }

    @After
    public void destruct() {
        System.setErr(errStream);
    }

    @Test
    public void testValidCitiesOutputCalled() {
        when(weatherFetcher.fetchCurrentWeather()).thenReturn(currentWeatherEntity);
        when(weatherFetcher.fetchWeatherForecast()).thenReturn(weatherForecastEntity);
        controller.start();
        verify(output).makeReport(any(ReportMaker.class));
    }


    @Test
    public void testInvalidCitySystemErr() {
        when(weatherFetcher.fetchCurrentWeather()).thenReturn(null);
        when(weatherFetcher.fetchWeatherForecast()).thenReturn(null);
        controller.start();
        assertEquals("Invalid results for given city name." + System.lineSeparator(), errStreamToChange.toString());
    }


    @Test
    public void testInputMethodsCalled() {
        controller.start();
        verify(input).readNextCityLine();
    }

    @Test
    public void testRequesterSetCityCalled() {
        controller.start();
        verify(weatherFetcher).setCity(anyString());
    }


    @Test
    public void testRequesterForecastFetchingMethodCalled() {
        controller.start();
        verify(weatherFetcher).fetchCurrentWeather();
    }

    @Test
    public void testRequesterCurrentWeatherFetchingMethodCalled() {
        controller.start();
        verify(weatherFetcher).fetchWeatherForecast();
    }
}
