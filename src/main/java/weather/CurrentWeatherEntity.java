package weather;

import locations.PositionData;


public class CurrentWeatherEntity extends WeatherEntity {

    private Weather currentWeather;

    public CurrentWeatherEntity(PositionData positionData, Weather weather) {
        super(positionData);
        this.currentWeather = weather;
    }

    public Weather getCurrentWeather() {
        return currentWeather;
    }
}
