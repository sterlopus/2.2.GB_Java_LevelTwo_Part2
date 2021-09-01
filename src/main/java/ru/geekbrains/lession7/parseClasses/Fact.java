package ru.geekbrains.lession7.parseClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fact {
    private float temp;
    private float feels_like;
    private String condition;

    // Getter Methods
    public float getTemp() {
        return temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public String getCondition() {
        return condition;
    }

}