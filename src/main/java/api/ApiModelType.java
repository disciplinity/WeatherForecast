package api;



public class ApiModelType {

    private Class<? extends ApiModel> currentWeatherModel;
    private Class<? extends ApiModel> weatherForecastModel;

    public ApiModelType(Class<? extends ApiModel> currentWeatherModel, Class<? extends ApiModel> weatherForecastModel) {
        this.currentWeatherModel = currentWeatherModel;
        this.weatherForecastModel = weatherForecastModel;
    }

    public Class<? extends ApiModel> getTypeOfCurrentWeatherModel() {
        return currentWeatherModel;
    }

    public Class<? extends ApiModel> getTypeOfForecastModel() {
        return weatherForecastModel;
    }
}