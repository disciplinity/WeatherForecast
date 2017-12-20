package weather;

/**
 * Created by Daiy on 17.12.2017.
 */
public class SingleDayMinAndMaxWeather {

    public Weather minTemperature;
    public Weather maxTemperature;

    public SingleDayMinAndMaxWeather(Weather minTemperature, Weather maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }
}
