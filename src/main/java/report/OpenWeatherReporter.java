package report;

import exceptions.WeatherEntitiesDoNotExistException;
import json.JsonMaker;
import weather.CurrentWeatherEntity;
import weather.WeatherForecastEntity;



public class OpenWeatherReporter implements ReportMaker {

    private CurrentWeatherEntity currentWeather;
    private WeatherForecastEntity weatherForecastEntity;

    public OpenWeatherReporter(CurrentWeatherEntity currentWeatherEntity, WeatherForecastEntity weatherForecastEntity) {
        this.currentWeather = currentWeatherEntity;
        this.weatherForecastEntity = weatherForecastEntity;
    }

    public String makeReport() {
        if (currentWeather == null || weatherForecastEntity == null) {
            throw new WeatherEntitiesDoNotExistException("One of the or both of the weather entities are missing");
        }

        JsonMaker jsonMaker = new JsonMaker(currentWeather, weatherForecastEntity);
        return jsonMaker.makeJsonString();
    }

}
