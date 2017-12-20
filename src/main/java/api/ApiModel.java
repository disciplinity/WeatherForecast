package api;


import locations.Position;
import weather.SingleDayMinAndMaxWeather;
import weather.Weather;

// Wrapping outer API as recommended by Kaspar in his slides
public interface ApiModel {
    String getName();
    String getCode();
    Position getPosition();

    default Weather getWeather() {
        return null;
    }

    default SingleDayMinAndMaxWeather[] getThreeDayWeatherForecast() {
        return null;
    }
}