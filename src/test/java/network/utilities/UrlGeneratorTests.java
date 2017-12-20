package network.utilities;

import api.OpenWeatherUrlConstants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UrlGeneratorTests {

    private final String givenCity = "Honolulu";
    private final UrlGenerator urlGenerator = new UrlGenerator();

    private String fetchValidLink(String choiceBetweenForecastAndCurrentWeather) {
        return String.format(
                "http://api.openweathermap.org/data/2.5/%s?q=%s%s",
                choiceBetweenForecastAndCurrentWeather, givenCity, OpenWeatherUrlConstants.KEY);
    }

    @Before
    public void initialize() {
        urlGenerator.setCurrentCity(givenCity);

    }


    @Test(expected = IllegalStateException.class)
    public void testFetchForecastLinkWithoutGivenCity() {
        UrlGenerator generator = new UrlGenerator();
        generator.generateForecastLink();
    }

    @Test
    public void fetchLinkForCurrentWeather() {
        assertEquals(fetchValidLink("weather"), urlGenerator.generateCurrentWeatherLink());
    }

    @Test
    public void fetchLinkForWeatherForecast() {
        assertEquals(fetchValidLink("forecast"), urlGenerator.generateForecastLink());
    }
}
