package network.utilities;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.HttpURLConnection;


public class HttpConnectionTests {


    private final String goodLink = "http://www.reddit.com";
    private final String badLink = "http://i_want_to_sleep_badly.please_let_me_sleep";
    private final UrlGenerator urlGenerator = new UrlGenerator();
    private final int BAD_RESPONSE_CODE = -1;
    private final String givenCity = "Honolulu";

    private String fetchContentFromConn(String city) {
        urlGenerator.setCurrentCity(city);
        HttpURLConnection conn = HttpConnectionService.getConnectionByLink(urlGenerator.generateCurrentWeatherLink());
        if (conn != null) {
            return HttpConnectionService.getContentFromConnection(conn);
        }
        return null;
    }

    private int connectTo(String link) {
        HttpURLConnection connection = HttpConnectionService.getConnectionByLink(link);
        try {
            return connection.getResponseCode();
        } catch (Exception e) {
            return BAD_RESPONSE_CODE;
        }
    }

    @Before
    public void init() {
        urlGenerator.setCurrentCity(givenCity);
    }

    @Test
    public void testErrorWhenConnecting() {
        assertEquals(-1, connectTo(badLink));
    }

    @Test
    public void testConnectingToCurrentWeatherApiAndGettingGoodResponse() {
        assertEquals(200, connectTo(urlGenerator.generateCurrentWeatherLink()));
    }

    @Test
    public void testConnectingToWeatherForecastApiAndGettingGoodResponse() {
        assertEquals(200, connectTo(urlGenerator.generateForecastLink()));
    }

    @Test
    public void testGetCityFromConnection() {
        String content = fetchContentFromConn(givenCity);
        assertTrue(content != null);
    }



    @Test
    public void testGetWrongCityFromConnection() {
        String content = fetchContentFromConn("plzIWantToSleep");
        assertFalse(content != null);
    }


}
