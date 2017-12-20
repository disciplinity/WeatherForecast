package weather.requests;

import api.ApiModelType;
import api.OpenWeatherApiCurrentWeather;
import api.OpenWeatherApiWeatherForecast;
import javafx.geometry.Pos;
import locations.Position;
import network.utilities.UrlGenerator;
import org.junit.Before;
import weather.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class WeatherRequestTests {

    private WeatherEntity currentWeatherEntity;
    private WeatherEntity weatherForecastEntity;
    private WeatherFetcher weatherFetcher;

    @Before
    public void initSetup() {
        weatherFetcher = WeatherFetcher.createWeatherFetcherWithDefinedCity("Tallinn",
                new ApiModelType(OpenWeatherApiCurrentWeather.class, OpenWeatherApiWeatherForecast.class), new UrlGenerator());
    }

    @Test
    public void testCurrentWeatherCreation() {
        currentWeatherEntity = weatherFetcher.fetchCurrentWeather();
        assertNotEquals(null, currentWeatherEntity);
    }

    @Test
    public void testWeatherForecastCreation() {
        weatherForecastEntity = weatherFetcher.fetchWeatherForecast();
        assertNotEquals(null, weatherForecastEntity);
    }

    @Test
    public void testCurrentWeatherCreationgWhenWeatherExists() {
        currentWeatherEntity = weatherFetcher.fetchCurrentWeather();
        if (currentWeatherEntity != null) {
            Weather weather = ((CurrentWeatherEntity) currentWeatherEntity).getCurrentWeather();
            assertNotEquals(null, weather);
        } else {
            fail("Error occurred when creating CurrentWeather");
        }
    }

    @Test
    public void testWeatherForecastCreationWhenForecastExists() {
        weatherForecastEntity = weatherFetcher.fetchWeatherForecast();
        if (weatherForecastEntity != null) {
            SingleDayMinAndMaxWeather[] weather = ((WeatherForecastEntity) weatherForecastEntity).getSingleDayMinAndMaxWeather();
            assertNotEquals(null, weather);
        } else {
            fail("Error occurred when creating WeatherForecast");
        }
    }

    @Test
    public void testCurrentWeatherCreationWhenPositionDataExists() {
        currentWeatherEntity = weatherFetcher.fetchCurrentWeather();
        if (currentWeatherEntity != null) {
            Position position = currentWeatherEntity.getPosition();
            String city = currentWeatherEntity.getCityName();
            String countryCode = currentWeatherEntity.getCountryCode();
            assertFalse((position == null || city == null || countryCode == null));
        } else {
            fail("Current weather not created");
        }
    }

    @Test
    public void testWeatherForecastCreationPositionDataExists() {
        weatherForecastEntity = weatherFetcher.fetchWeatherForecast();
        if (weatherForecastEntity != null) {
            Position position = weatherForecastEntity.getPosition();
            String city = weatherForecastEntity.getCityName();
            String countryCode = weatherForecastEntity.getCountryCode();
            assertFalse((position == null || city == null || countryCode == null));
        } else {
            fail("Error occurred when creating weather forecast.");
        }
    }
}
