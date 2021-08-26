package ru.geekbrains.lession7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coordinates {
    @Getter @Setter
    private String lat;
    @Getter @Setter
    private String lng;

    public Coordinates() {
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
