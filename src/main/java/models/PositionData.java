package models;


public class PositionData {

    public String cityName;
    public String countryCode;
    public Position position;

    public PositionData(String cityName, String countryCode, Position position) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.position = position;
    }

}
