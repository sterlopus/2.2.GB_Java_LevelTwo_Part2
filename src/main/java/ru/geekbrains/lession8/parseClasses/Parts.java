package ru.geekbrains.lession8.parseClasses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parts {
    private Day day;

    public Parts(){
    }

    public Parts(Day day) {
        this.day = day;
    }

    public Day getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "day=" + day +
                '}';
    }
}
