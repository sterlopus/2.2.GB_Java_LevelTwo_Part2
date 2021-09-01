package ru.geekbrains.lession7.parseClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.geekbrains.lession7.Lession7;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("forecasts")
        private List< DailyForecast > dailyForecast = new ArrayList <> ();

        public WeatherResponse(){
        }

        public WeatherResponse(List<DailyForecast> dailyForecast) {
            this.dailyForecast = dailyForecast;
        }


    public List<DailyForecast> getDailyForecast() {
        return dailyForecast;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "dailyForecast=" + dailyForecast +
                '}';
    }
}