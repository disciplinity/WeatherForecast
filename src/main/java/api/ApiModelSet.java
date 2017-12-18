package api;



public class ApiModelSet {

    private Class<? extends ApiModel> currentWeatherModel;
    private Class<? extends ApiModel> forecastModel;

    public ApiModelSet(Class<? extends ApiModel> currentWeatherModel, Class<? extends ApiModel> forecastModel) {
        this.currentWeatherModel = currentWeatherModel;
        this.forecastModel = forecastModel;
    }

    public Class<? extends ApiModel> getTypeOfCurrent() {
        return currentWeatherModel;
    }

    public Class<? extends ApiModel> getTypeOfForecast() {
        return forecastModel;
    }
}