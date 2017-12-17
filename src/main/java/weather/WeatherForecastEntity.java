package weather;


import locations.PositionData;

public class WeatherForecastEntity extends WeatherEntity {

    private ThreeDayForecastContainer[] threeDayForecastContainer = new ThreeDayForecastContainer[3];

    public WeatherForecastEntity(PositionData positionData, ThreeDayForecastContainer[] threeDayForecastContainer) {
        super(positionData);
        this.threeDayForecastContainer = threeDayForecastContainer;
    }

    public ThreeDayForecastContainer[] getThreeDayForecastContainer() {
        return threeDayForecastContainer;
    }
}