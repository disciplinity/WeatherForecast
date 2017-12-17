package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Daiy on 17.12.2017.
 */
public class WeatherModelTests {

    private Weather weatherInCelsius;
    private Weather weatherInFahrenheit;
    private Weather weatherInKelvin;

    @Before
    public void initialize() {
        weatherInCelsius = new Weather(0, "celsius"); // Will put all the units into constants later on
        weatherInFahrenheit = new Weather(32, "fahrenheit");
        weatherInKelvin = new Weather(273.15, "kelvin");

    }

    @Test
    public void testTemperature() {
        assertEquals(0, weatherInCelsius.getTemperature(), 0.1);
    }

    @Test
    public void testTemperatureUnits() {
        assertEquals("celsius", weatherInCelsius.getTemperatureUnits());
    }

    @Test
    public void testEqualTemperatureInCelsiusAndFahrenheit() {
        assertequals(weatherInCelsius, weatherInFahrenheit, 0.1);
    }

    @Test
    public void testEqualTemperatureInCelsiusAndKelvin() {
        assertEquals(weatherInCelsius, weatherInKelvin);
    }

    @Test
    public void testEqualTemperatureInFahrenheitAndKelvin() {
        assertEquals(weatherInFahrenheit, weatherInKelvin);
    }


}
