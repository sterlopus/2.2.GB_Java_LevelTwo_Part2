package ru.geekbrains.lession8.parseClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {
    private double temp_avg;

    public Day (){
    }

    public Day(double temp_avg) {
        this.temp_avg = temp_avg;
    }

    public double getTemp_avg() {
        return temp_avg;
    }

    @Override
    public String  toString() {
        return "Day{" +
                "temp_avg=" + temp_avg +
                '}';
    }
}
