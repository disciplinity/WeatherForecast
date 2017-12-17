package weather;


import locations.Position;
import locations.PositionData;

public abstract class WeatherEntity {

    private Position position;
    private String cityName;
    private String countryCode;

    WeatherEntity(PositionData data) {
        if (data != null) {
            this.cityName = data.cityName;
            this.countryCode = data.countryCode;
            this.position = data.position;
        }
    }

    public String getCityName() {
        return cityName;
    }

    public Position getPosition() {
        return position;
    }

    public String getCountryCode() {
        return countryCode;
    }
}