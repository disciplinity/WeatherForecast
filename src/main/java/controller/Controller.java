package controller;

import input.output.InputBaseClass;
import input.output.OutputFile;
import report.OpenWeatherReporter;
import report.ReportMaker;
import weather.CurrentWeatherEntity;
import weather.WeatherEntity;
import weather.WeatherFetcher;
import weather.WeatherForecastEntity;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;



public class Controller {

    private OutputFile outputFile;
    private WeatherFetcher weatherFetcher;
    private InputBaseClass userInput;


    public Controller(WeatherFetcher weatherFetcher, InputBaseClass userInput, OutputFile outputFile) {
        this.weatherFetcher = weatherFetcher;
        this.userInput = userInput;
        this.outputFile = outputFile;
    }

    public void start() {
        String[] cities = userInput.readNextCityLine();
        Arrays.asList(cities).forEach(city -> {
            try {
                System.out.println(city);
                weatherFetcher.setCity(city);

                WeatherEntity fetchedCurrentWeather = weatherFetcher.fetchCurrentWeather();
                WeatherEntity fetchedWeatherForecast = weatherFetcher.fetchWeatherForecast();

                if (!(fetchedCurrentWeather != null && fetchedWeatherForecast != null)) {
                    System.err.println("Invalid results for given city name");
                    return;
                }

                WeatherForecastEntity forecastToWrite = (WeatherForecastEntity) fetchedWeatherForecast;
                CurrentWeatherEntity weatherToWrite = (CurrentWeatherEntity) fetchedCurrentWeather;

                outputFile.setFile(new File(String.format("%s.txt", city.toUpperCase())));
                createReports(weatherToWrite, forecastToWrite);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void createReports(CurrentWeatherEntity currentWeather, WeatherForecastEntity weatherForecastEntity)
            throws IOException {
        ReportMaker openWeatherApiReportMaker = new OpenWeatherReporter(currentWeather, weatherForecastEntity);
        outputFile.makeReport(openWeatherApiReportMaker);
    }
}
