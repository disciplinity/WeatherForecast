package api;

import locations.Position;
import weather.SingleDayMinAndMaxWeather;
import weather.Weather;

import java.util.HashMap;

/**
 * Created by Daiy on 18.12.2017.
 */
public class OpenWeatherApiCurrentWeather implements ApiModel {
    public HashMap<String, Float> coordinates;
    public HashMap<String, Float> main;
    public HashMap<String, Object> sys;
    public String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCode() {
        return (String) sys.get("country");
    }

    @Override
    public Position getPosition() {
        double lat = (double) coordinates.get("lat");
        double lon = (double) coordinates       .get("lon");
        return new Position(lat, lon);
    }

    public Weather getWeather() {
        return new Weather(main.get("temp"), Weather.TemperatureUnits.kelvin);
    }


}
