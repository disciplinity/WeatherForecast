package main;

import api.ApiModelType;
import api.OpenWeatherApiCurrentWeather;
import api.OpenWeatherApiWeatherForecast;
import controller.Controller;
import input.output.InputFromConsole;
import input.output.InputFromFile;
import input.output.OutputFile;
import network.utilities.UrlGenerator;
import weather.WeatherFetcher;

import java.io.File;
import java.io.IOException;



public class Main {

    public static void main(String[] args) {
        try {
            UrlGenerator generator = new UrlGenerator();
            generator.setCurrentCity("Tallinn");
            OutputFile outputFile = new OutputFile(new File("Tallinn.txt"));
            Controller controller = new Controller(WeatherFetcher.createWeatherFetcherWithDefinedCity(generator.getCurrentCity(),
                                                    new ApiModelType(OpenWeatherApiCurrentWeather.class,
                                                    OpenWeatherApiWeatherForecast.class), generator), new InputFromFile(new File("abc.txt")), outputFile);
            controller.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
