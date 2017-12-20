package weather;

import api.ApiModel;
import api.ApiModelType;
import com.google.gson.Gson;
import locations.PositionData;
import network.utilities.HttpConnectionService;
import network.utilities.UrlGenerator;

import java.net.HttpURLConnection;



public class WeatherFetcher {

    private UrlGenerator urlGenerator;
    private String city;
    private String url;
    private String forecastUrl;
    private Gson gson = new Gson();
    private ApiModelType apiModelType;

    private WeatherFetcher(String city, UrlGenerator urlGenerator, ApiModelType apiModelType) {
        this.city = city;
        this.urlGenerator = urlGenerator;
        this.apiModelType = apiModelType;
        updateLinks();
    }

    public WeatherFetcher() {

    }

    private void updateLinks() {
        urlGenerator.setCurrentCity(String.valueOf(city));
        url = urlGenerator.generateCurrentWeatherLink();
        forecastUrl = urlGenerator.generateForecastLink();
    }

    public void setCity(String city) {
        this.city = city;
        updateLinks();
    }


    public static WeatherFetcher createWeatherFetcherWithDefinedCity(String city, ApiModelType apiModelType, UrlGenerator urlGenerator) {
        return new WeatherFetcher(city, urlGenerator, apiModelType);
    }

    public static WeatherFetcher createWeatherFetcherWithUndefinedCity(ApiModelType apiModelType, UrlGenerator urlGenerator) {
        return new WeatherFetcher("undefined", urlGenerator, apiModelType);
    }


    public WeatherEntity fetchCurrentWeather() {

    String json = getJsonFromUrl(url);
    ApiModel parsedWeather = gson.fromJson(json, apiModelType.getTypeOfCurrentWeatherModel());
    PositionData positionData = getPositionDataFromApiModel(parsedWeather);

    return new CurrentWeatherEntity(positionData, parsedWeather.getWeather());

    }

    public WeatherEntity fetchWeatherForecast() {

        String json = getJsonFromUrl(forecastUrl);
        ApiModel parsedWeather = gson.fromJson(json,
                    apiModelType.getTypeOfForecastModel());

        PositionData data = getPositionDataFromApiModel(parsedWeather);

        return new WeatherForecastEntity(data, parsedWeather.getThreeDayWeatherForecast());
    }

    private String getJsonFromUrl(String url) {
        HttpURLConnection connection = HttpConnectionService.getConnectionByLink(url);
        return HttpConnectionService.getContentFromConnection(connection);
    }

    private PositionData getPositionDataFromApiModel(ApiModel parsedWeather) {
        return new PositionData(parsedWeather.getName(), parsedWeather.getPosition(), parsedWeather.getCode());
    }
}
