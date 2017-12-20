package weather;


import locations.PositionData;

public class WeatherForecastEntity extends WeatherEntity {

    private SingleDayMinAndMaxWeather[] singleDayMinAndMaxWeather = new SingleDayMinAndMaxWeather[3];

    public WeatherForecastEntity(PositionData positionData, SingleDayMinAndMaxWeather[] singleDayMinAndMaxWeather) {
        super(positionData);
        this.singleDayMinAndMaxWeather = singleDayMinAndMaxWeather;
    }

    public SingleDayMinAndMaxWeather[] getSingleDayMinAndMaxWeather() {
        return singleDayMinAndMaxWeather;
    }
}