package api;

import com.google.gson.internal.LinkedTreeMap;
import locations.Position;
import weather.SingleDayMinAndMaxWeather;
import weather.Weather;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by Daiy on 18.12.2017.
 */
public class OpenWeatherApiWeatherForecast implements ApiModel {

    public HashMap<String, Object> city;
    public HashMap<String, Object>[] list;

    @SuppressWarnings("unchecked")
    private SingleDayMinAndMaxWeather[] getThreeDayWeatherForecast() {
        TreeMap<String, SingleDayMinAndMaxWeather> weathersByDay = new TreeMap<>();
        SingleDayMinAndMaxWeather[] threeDayForecast = new SingleDayMinAndMaxWeather[3];
        int counter = 0;
        for (HashMap<String, Object> aList : list) {
            if (counter == 3) break;
            LinkedTreeMap<String, Double> weathers = (LinkedTreeMap<String, Double>) aList.get("main");
            Weather minTemp = new Weather(weathers.get("temp_min"), Weather.TemperatureUnits.kelvin);
            Weather maxTemp = new Weather(weathers.get("temp_max"), Weather.TemperatureUnits.kelvin);
            String date = ((String) aList.get("dt_txt")).substring(0, 10);
            counter = createWeatherForecasts(weathersByDay, threeDayForecast, counter, minTemp, maxTemp, date);
        }
        return threeDayForecast;
    }

    private int createWeatherForecasts(TreeMap<String, SingleDayMinAndMaxWeather> weathersByDay, SingleDayMinAndMaxWeather[] singleDayMinAndMaxWeathers,
                                       int counter, Weather minTemperature, Weather maxTemperature, String date) {
        if (weathersByDay.containsKey(date)) {
            if (weathersByDay.get(date).minTemperature.compareTo(minTemperature) == 1) {
                weathersByDay.get(date).minTemperature = minTemperature;
            }
            if (weathersByDay.get(date).maxTemperature.compareTo(maxTemperature) == -1) {
                weathersByDay.get(date).maxTemperature = maxTemperature;
            }
        } else {
            weathersByDay.put(date, new SingleDayMinAndMaxWeather(minTemperature, maxTemperature));
            singleDayMinAndMaxWeathers[counter++] = weathersByDay.get(date);
        }
        return counter;
    }


    @Override
    @SuppressWarnings("unchecked")
    public Position getPosition() {
        LinkedTreeMap<String, Double> coords = (LinkedTreeMap<String, Double>) city.get("coord");
        double lat =  coords.get("lat");
        double lon = coords.get("lon");
        return new Position(lat, lon);
    }

    public SingleDayMinAndMaxWeather[] getWeatherForecast() {
        return getThreeDayWeatherForecast();

    }

    @Override
    public String getName() {
        return (String) city.get("name");
    }

    @Override
    public String getCode() {
        return (String) city.get("country");
    }
}