package json;


import com.google.gson.JsonObject;
import weather.CurrentWeatherEntity;
import weather.WeatherForecastEntity;

public class JsonMaker {

    private CurrentWeatherEntity currentWeather;
    private WeatherForecastEntity weatherForecastEntity;

    public JsonMaker(CurrentWeatherEntity currentWeather, WeatherForecastEntity weatherForecastEntity) {
        this.weatherForecastEntity = weatherForecastEntity;
        this.currentWeather = currentWeather;
    }

    public String makeJsonString() {
        JsonObject jsonObject = new JsonObject();

        JsonObject forecastJson = new JsonObject();
        JsonObject[] forecastDays = {new JsonObject(), new JsonObject(), new JsonObject()};

        for (int day = 0; day < 3; day++) {
            forecastDays[day].addProperty("min", weatherForecastEntity.getSingleDayMinAndMaxWeather()[day].minTemperature.getTemperature());
            System.out.println(weatherForecastEntity.getSingleDayMinAndMaxWeather()[day].minTemperature.getTemperature());
            forecastDays[day].addProperty("max", weatherForecastEntity.getSingleDayMinAndMaxWeather()[day].maxTemperature.getTemperature());
            forecastJson.add(String.valueOf(day), forecastDays[day]);
        }


        jsonObject.addProperty("cityName", currentWeather.getCityName());
        jsonObject.addProperty("latitude", currentWeather.getPosition().getLatitude());
        jsonObject.addProperty("longitude", currentWeather.getPosition().getLongitude());
        jsonObject.add("forecast", forecastJson);
        jsonObject.addProperty("currentWeather", currentWeather.getCurrentWeather().getTemperature());

        return jsonObject.toString();
    }
}

