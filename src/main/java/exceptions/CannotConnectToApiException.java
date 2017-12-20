package exceptions;


public class CannotConnectToApiException extends RuntimeException {

    public CannotConnectToApiException(String message) {
        super(message);
    }
}
