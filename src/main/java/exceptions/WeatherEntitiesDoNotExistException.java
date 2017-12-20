package exceptions;


public class WeatherEntitiesDoNotExistException extends RuntimeException{

    public WeatherEntitiesDoNotExistException(String message) {
        super(message);
    }

}
