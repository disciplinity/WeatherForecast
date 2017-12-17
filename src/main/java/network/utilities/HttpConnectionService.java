package network.utilities;

import exceptions.CannotConnectToApiException;

import java.net.HttpURLConnection;
import java.net.URL;


public class HttpConnectionService {


    public HttpURLConnection getConnectionByLink(String link) {
        try {
            URL url = new URL(link);
            return (HttpURLConnection) url.openConnection();
        } catch (java.io.IOException e) {
            throw new CannotConnectToApiException("Unable to connect");
        }
    }
}
