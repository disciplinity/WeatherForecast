package models;

import org.junit.Before;
import org.junit.Test;
import weather.Weather;

import static org.junit.Assert.assertEquals;



public class WeatherModelTests {

    private Weather weather;


    @Before
    public void initialize() {
        weather = new Weather(100.0, Weather.TemperatureUnits.kelvin);
    }

    @Test
    public void testTemperature() {
        assertEquals(100.0, weather.getTemperature(), 0.1);
    }

    @Test
    public void testTemperatureUnits() {
        assertEquals(Weather.TemperatureUnits.kelvin, weather.getTemperatureUnits());
    }

    @Test
    public void testSameTemperatureDifferentUnitsCelsiusKelvin() {
        Weather weather = new Weather(0, Weather.TemperatureUnits.celsius);
        Weather weather1 = new Weather(273.15, Weather.TemperatureUnits.kelvin);
        assertEquals(weather1, weather);
    }

    @Test
    public void testSameTemperatureDifferentUnitsCelsiusFahrenheit() {
        Weather weather = new Weather(10, Weather.TemperatureUnits.celsius);
        Weather weather1 = new Weather(50, Weather.TemperatureUnits.fahrenheit);
        assertEquals(weather1, weather);
    }

    @Test
    public void testSameTemperatureDifferentUnitsFahrenheitKelvin() {
        Weather weather = new Weather(14, Weather.TemperatureUnits.fahrenheit);
        Weather weather1 = new Weather(263.15, Weather.TemperatureUnits.kelvin);
        assertEquals(weather1, weather);
    }


}
