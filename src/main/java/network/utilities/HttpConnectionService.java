package network.utilities;

import java.net.HttpURLConnection;
import java.net.URL;


public class HttpConnectionService {

    public static HttpURLConnection getConnectionByLink(String link) {
        try {
            URL url = new URL(link);
            return (HttpURLConnection) url.openConnection();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
