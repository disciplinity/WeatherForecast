package network.utilities;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;

/**
 * Created by Daiy on 16.12.2017.
 */
public class HttpConnectionTests {

    private HttpConnectionService httpConnectionService;
    private String url;
    private LinkGenerator linkGenerator;

    @Before
    public void initialize() {
        httpConnectionService = new HttpConnectionService();
    }

    @Test (expected = SocketTimeoutException.class)
    public void connectionToWrongPort() {
        url = "https://www.reddit.com:32";
        httpConnectionService.makeConnectionFromURL(url);
    }

    @Test
    public void successfulConnectionToWeatherApi() {
        url = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";
        try {
            httpConnectionService.makeConnectionFromURL(url);
            assertEquals(HttpURLConnection.HTTP_OK, httpConnectionService.getResponseCode());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void successfulConnectionToAnyWebsite() {
        url = "http://www.youtube.com";
        try {
            httpConnectionService.makeConnectionFromURL(url);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
