package weather;

/**
 * Created by Daiy on 17.12.2017.
 */
public class ThreeDayForecastContainer {

    public Weather minTemperature;
    public Weather maxTemperature;

    public ThreeDayForecastContainer(Weather minTemp, Weather maxTemp) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }
}
