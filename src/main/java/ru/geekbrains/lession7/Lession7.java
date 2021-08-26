package ru.geekbrains.lession7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Lession7 {
    public static void main(String[] args) throws IOException {

        String  city = "Москва";

        CityGeocoding cityGeocoding = new CityGeocoding(city);
        String output = cityGeocoding.cityCoordinates();
        System.out.println("all json:" + output);

        ObjectMapper objectMapper = new ObjectMapper();
        Coordinates coordinates = objectMapper.readValue(output, Coordinates.class);
//        System.out.println(coordinates.getLat());
//        System.out.println(coordinates.getLng());
        System.out.println("coords:" + coordinates.toString());

//        WeatherReport weatherReport = new WeatherReport(city);
//        System.out.println("5 days forecast is: " + );

    }
}


/**
 * * 1.С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
 * * пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
 * **
 * * 2.Подобрать источник самостоятельно.
 * * Можно использовать api accuweather, порядок следующий: зарегистрироваться, зарегистрировать тестовое приложение*
 * * для получения api ключа, найдите нужный endpoint и изучите документацию. Бесплатный тарифный план предполагает*
 * * получение погоды не более чем на 5 дней вперед (этого достаточно для выполнения д/з).
 **/

