package exceptions;

/**
 * Created by Daiy on 16.12.2017.
 */
public class CannotConnectToApiException extends RuntimeException {

    public CannotConnectToApiException(String message) {
        super(message);
    }
}
