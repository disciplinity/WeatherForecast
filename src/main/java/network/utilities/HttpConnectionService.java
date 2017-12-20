package network.utilities;

import exceptions.CannotConnectToApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpConnectionService {


    public static HttpURLConnection getConnectionByLink(String link) {
        try {
            URL url = new URL(link);
            return (HttpURLConnection) url.openConnection();
        } catch (java.io.IOException e) {
            throw new CannotConnectToApiException("Unable to connect");
        }
    }

    public static String getContentFromConnection(HttpURLConnection httpURLConnection) {

        try {
            httpURLConnection.connect();
            StringBuilder strBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));

            while (bufferedReader.ready() == true) {
                strBuilder.append(bufferedReader.readLine());
            }
            return strBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            // if city doesn't exist
            return null;
        }
    }
}
