package ru.geekbrains.lession7.parseClasses;

import java.util.ArrayList;

public class WeatherResponse {

        Fact FactObject;
        ArrayList< Object > forecasts = new ArrayList < Object > ();


        public Fact getFact() {
            return FactObject;
        }
}