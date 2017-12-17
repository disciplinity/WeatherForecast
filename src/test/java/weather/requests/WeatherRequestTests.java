package weather.requests;

import org.junit.Test;

import static org.junit.Assert.*;


public class WeatherRequestTests {

    private WeatherFetcher weatherFetcher;
    private WeatherEntity currentWeatherEntity;
    private WeatherEntity weatherForecastEntity;

    @Test
    public void fetchCurrentWeather() {
        currentWeatherEntity = weatherFetcher.fetchCurrentWeather();
        assertNotEquals(null, currentWeatherEntity);
    }

    @Test
    public void fetchWeatherForecast() {
        weatherForecastEntity = weatherFetcher.fetchWeatherForecast();
        assertNotEquals(null, weatherForecastEntity);
    }

    @Test
    public void testCurrentWeatherCreationWeatherExists() {
        currentWeatherEntity = weatherFetcher.fetchCurrentWeather();
        if (currentWeatherEntity != null) {
            Weather weather = ((CurrentWeatherEntity) currentWeatherEntity).getCurrentWeather();
            assertNotEquals(null, weather);
        } else {
            fail("Problem occurred creating current weather.");
        }
    }

    @Test
    public void testForecastCreationForecastExists() {
        weatherForecastEntity = weatherFetcher.fetchWeatherForecast();
        if (weatherForecastEntity != null) {
            ThreeDayForecastContainer[] threeDayForecastContainer = ((WeatherForecastEntity) weatherForecastEntity).getForecast();
            assertNotEquals(null, threeDayForecastContainer);
        } else {
            fail("Problem occurred when creating forecast weather.");
        }
    }


}
