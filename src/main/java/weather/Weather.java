package weather;


public class Weather implements Comparable<Weather> {

    public enum TemperatureUnits {
        kelvin, fahrenheit, celsius
    }

    private double temperature;
    private TemperatureUnits temperatureUnits;

    public Weather(double temperature, TemperatureUnits temperatureUnits) {
        this.temperature = temperature;
        this.temperatureUnits = temperatureUnits;
    }

    public double getTemperature() {
        return temperature;
    }

    public TemperatureUnits getTemperatureUnits() {
        return temperatureUnits;
    }

    public int compareTo(Weather o) {
        if  (this.getTemperatureInKelvins() > o.getTemperatureInKelvins())
            return 1;
        else if (this.getTemperatureInKelvins() == o.getTemperatureInKelvins())
            return 0;
        return -1;
    }

    @Override
    public boolean equals(Object weather) {
        return weather instanceof Weather && ((Weather) weather).getTemperatureInKelvins() == this.getTemperatureInKelvins();
    }

    private double getTemperatureInKelvins() {
        switch (temperatureUnits) {
            case kelvin:
                return temperature;
            case celsius:
                return temperature + 273.15;
            case fahrenheit:
                return (temperature + 459.67) * 5/9;
            default:
                throw new IllegalArgumentException("Temperature units are measured in kelvins, celsius and fahrenheit only!");
        }
    }

}
