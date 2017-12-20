package locations;


public class PositionData {

    public String cityName;
    public String countryCode;
    public Position position;

    public PositionData(String cityName, Position position, String countryCode) {
        this.cityName = cityName;
        this.position = position;
        this.countryCode = countryCode;

    }

}
