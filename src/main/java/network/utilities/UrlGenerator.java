package network.utilities;


public class UrlGenerator {

    private String currentCity;

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    enum LinkType {
        FORECAST, CURRENT_WEATHER
    }

    private String generateLink(LinkType type) {
        if (currentCity == null) {
            throw new IllegalStateException("City name is not set in link generator object!");
        }

        return null; // not sure how i'll do it here later on, will leave for now
    }


    public String generateForecastLink() {
        return generateLink(LinkType.FORECAST);
    }

    public String generateCurrentWeatherLink() {
        return generateLink(LinkType.CURRENT_WEATHER);
    }
}
