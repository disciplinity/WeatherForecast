package models;


public class Position {

    private final double longitude;
    private final double latitude;

    public Position(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public boolean equals(Object comparedObject) {
        return comparedObject instanceof  Position
                &&((Position) comparedObject).getLatitude() == latitude
                && ((Position) comparedObject).getLongitude() == longitude;
    }
}