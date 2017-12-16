package network.utilities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Daiy on 17.12.2017.
 */
public class UrlGeneratorTests {

    private UrlGenerator urlGenerator;
    private String city;
    private String url;

    @Before
    public void initialize() {
        urlGenerator = new UrlGenerator();
        city = "Honolulu";
    }

    @Test
    public void createCurrentWeatherUrlByCityNameTest() {
        url = urlGenerator.createUrlForCurrentWeatherByCityName(city);
        assertEquals("http://api.openweathermap.org/data/2.5/weather?q=Honolulu&APPID=b23a28015112de497b276e514d2d04a0", url);
    }

    @Test
    public void createWeatherForecastUrlByCityNameTest() {
        url = urlGenerator.createUrlForWeatherForecastByCityName(city);
        assertEquals("http://api.openweathermap.org/data/2.5/forecast?q=Honolulu&APPID=b23a28015112de497b276e514d2d04a0", url);
    }

}
