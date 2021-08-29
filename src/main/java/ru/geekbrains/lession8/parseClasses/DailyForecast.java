package ru.geekbrains.lession8.parseClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
    private String date;
    private Parts parts;

    public DailyForecast(){
    }

    public DailyForecast(String date, Parts parts) {
        this.date = date;
        this.parts = parts;
    }

    public String getDate() {
        return date;
    }

    public Parts getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "DailyForecast{" +
                "date='" + date + '\'' +
                ", parts=" + parts +
                '}';
    }
}
