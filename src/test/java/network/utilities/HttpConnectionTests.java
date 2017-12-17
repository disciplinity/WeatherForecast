package network.utilities;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.SocketTimeoutException;


public class HttpConnectionTests {

    private HttpConnectionService httpConnectionService;
    private String url;

    @Before
    public void initialize() {
        httpConnectionService = new HttpConnectionService();
    }

    @Test (expected = SocketTimeoutException.class)
    public void connectionToWrongPort() {
        url = "https://www.reddit.com:32";
        httpConnectionService.getConnectionByLink(url);
    }

    @Test
    public void successfulConnectionToWeatherApi() {
        url = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";
        try {
            httpConnectionService.getConnectionByLink(url);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void successfulConnectionToAnyWebsite() {
        url = "http://www.youtube.com";
        try {
            httpConnectionService.getConnectionByLink(url);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
