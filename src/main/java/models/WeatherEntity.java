package models;


public abstract class WeatherEntity {

    private Position position;
    private String cityName;



    public String getCityName() {
        return cityName;
    }

    public Position getPosition() {
        return location;
    }
}