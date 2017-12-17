package weather.requests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;


/**
 * Created by Daiy on 17.12.2017.
 */
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
        currentWeatherEntity = requester.fetchCurrentWeather();
        if (currentWeatherEntity != null) {
            Weather weather = ((CurrentWeatherEntity) currentWeatherEntity).getCurrentWeather();
            assertNotEquals(null, weather);
        } else {
            fail("Problem occured creating current weather.");
        }
    }


}
