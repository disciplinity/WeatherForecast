package network.utilities;


import api.OpenWeatherUrlConstants;

public class UrlGenerator {

    private String currentCity;

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    enum UrlType {
        FORECAST, CURRENT_WEATHER
    }

    private String generateLink(UrlType urlType) {
        if (currentCity == null) {
            throw new IllegalStateException("City name is not set in link generator object!");
        }
        String weatherApiType = (UrlType.CURRENT_WEATHER == urlType) ? OpenWeatherUrlConstants.CURRENT_WEATHER_REQUEST : OpenWeatherUrlConstants.FORECAST_REQUEST;
        return OpenWeatherUrlConstants.API_URL_BASE + weatherApiType + "q=" + currentCity + OpenWeatherUrlConstants.API_KEY;
    }


    public String generateForecastLink() {
        return generateLink(UrlType.FORECAST);
    }

    public String generateCurrentWeatherLink() {
        return generateLink(UrlType.CURRENT_WEATHER);
    }
}
